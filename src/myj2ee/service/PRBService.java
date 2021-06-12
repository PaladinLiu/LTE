package myj2ee.service;

import javafx.util.Pair;
import myj2ee.dao.PRBDao;
import myj2ee.dao.PRBNewDao;
import myj2ee.utils.ImgGenerator;
import myj2ee.utils.MyResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PRBService {
    @Autowired
    private PRBDao prbDao;

    @Autowired
    private PRBNewDao prbNewDao;

    @Transactional
    public int generateNew(){
        List<String> colNames = prbDao.getAllColumnName();
        Map<String, Timestamp> limits = prbDao.getLimit();
        Timestamp max_time = limits.get("max_time");

        prbNewDao.clear();
        for(Timestamp t = limits.get("min_time"); t.before(max_time) || t.equals(max_time); t.setTime(t.getTime() + 60*60*1000)){
            try {
                prbNewDao.generateNew(t, new Timestamp(t.getTime() + 60*60*1000), colNames);
            }catch (RuntimeException e){
                e.printStackTrace();
                return -1;
            }
        }

        try {
            prbNewDao.export(new MyResultHandler<>(prbNewDao.getAllColumnName(), prbNewDao.getRowCount(), "tbprbnew.xlsx"));
        }catch (RuntimeException e){
            e.printStackTrace();
            return -1;
        }

        return 0;
    }

    public File getPRBAttributeByStationName(String stationName, String attribute, Timestamp startTime, Timestamp endTime){

        List<Map<String, Object>> res = prbNewDao.getPRBAttributeByStationName(stationName, attribute, startTime, endTime);

        List<Pair<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < res.size(); i++){
            data.add(new Pair<String, Object>(res.get(i).get("start_time").toString(), res.get(i).get(attribute)));
        }

        File img = ImgGenerator.generate(data, "在"+startTime+"到"+endTime+"之间基站"+stationName +"的"+attribute+"小时级变化","时间", attribute);

        return img;
    }

    public List<String> getAllStationNames(){
        return prbNewDao.getAllStationNames();
    }

}
