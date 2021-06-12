package myj2ee.service;

import myj2ee.bean.C2i;
import myj2ee.bean.C2inew;
import myj2ee.dao.C2i3Dao;
import myj2ee.dao.C2iDao;
import myj2ee.dao.C2inewDao;
import myj2ee.dao.MRODataDao;
import myj2ee.utils.MyResultHandler;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class C2iService {

    @Autowired
    private MRODataDao mroDataDao;

    @Autowired
    private C2inewDao c2inewDao;

    @Autowired
    private C2i3Dao c2i3Dao;

    @Transactional
    public int generateNew(){
        List<Map<String, Object>> c2is = mroDataDao.calculateC2I();
        c2inewDao.clear();
        for(Map<String, Object> c2i: c2is){
            if((double)c2i.get("C2I_std") == 0.0){
                c2i.put("PrbC2I9", (double)c2i.get("C2I_mean") < 9 ? 1:0);
                c2i.put("PrbABS6", Math.abs((double)c2i.get("C2I_mean")) < 6 ? 1:0);
            }else {
                NormalDistribution normalDistributioin = new NormalDistribution((double)c2i.get("C2I_mean"), (double)c2i.get("C2I_std"));
                c2i.put("PrbC2I9", normalDistributioin.cumulativeProbability(9));
                c2i.put("PrbABS6", normalDistributioin.cumulativeProbability(6) - normalDistributioin.cumulativeProbability(-6));
            }

        }
        c2inewDao.generateNew(c2is);

        int status;
        try {
            c2inewDao.export(new MyResultHandler<>(c2inewDao.getAllColumnName(), c2inewDao.getRowCount(), "tbc2inew.xlsx"));
            status = 0;
        }catch (RuntimeException e){
            e.printStackTrace();
            status = -1;
        }

        return status;
    }


    @Transactional
    public int generate3(double x){
        c2i3Dao.clear();
        c2i3Dao.generate3(x);

        int status;
        try{
            c2i3Dao.export(new MyResultHandler<>(c2i3Dao.getAllColumnName(), c2i3Dao.getRowCount(), "tbc2i3.xlsx"));
            status = 0;
        }catch (RuntimeException e){
            e.printStackTrace();
            status = -1;
        }

        return status;
    }
}
