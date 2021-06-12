package myj2ee.service;

import myj2ee.common.Common;
import myj2ee.dao.*;
import myj2ee.utils.MyResultHandler;
import myj2ee.utils.ProcessExcelUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableService {

    @Autowired
    private CellDao cellDao;

    @Autowired
    private MRODataDao mroDataDao;

    @Autowired
    private C2iDao c2iDao;

    @Autowired
    private C2inewDao c2inewDao;

    @Autowired
    private KPIDao kpiDao;

    @Autowired
    private PRBDao prbDao;

    @Autowired
    private PRBNewDao prbNewDao;

    @Transactional
    public List<Integer> exportTables(List<String> tableNames){
        Map<String, BaseDao> daoMapper = new HashMap<>();
        daoMapper.put("1.tbCell.csv", this.cellDao);
        daoMapper.put("9.tbMROData.xlsx", this.mroDataDao);
        daoMapper.put("10.tbC2I.xlsx", this.c2iDao);
        daoMapper.put("12.tbCellKPI-优化区17日-19日KPI指标统计表-0717至0719.xlsx", this.kpiDao);
        daoMapper.put("13.tbPRB-表13优化区17日-19日每PRB干扰查询-15分钟.xlsx", this.prbDao);

        List<Integer> list = new ArrayList<>();

        for(String tableName: tableNames){
            BaseDao dao = daoMapper.get(tableName);
            try {
                dao.export(new MyResultHandler<Map<String, Object>>(dao.getAllColumnName(), dao.getRowCount(), tableName));
                list.add(0);
            }catch (RuntimeException e){
                list.add(-1);
            }
        }

        return list;
    }

    @Transactional
    public List<Integer> importTables(List<String> tableNames){
        Map<String, BaseDao> daoMapper = new HashMap<>();
        daoMapper.put("1.tbCell.csv", this.cellDao);
        daoMapper.put("9.tbMROData.xlsx", this.mroDataDao);
        daoMapper.put("10.tbC2I.xlsx", this.c2iDao);
        daoMapper.put("12.tbCellKPI-优化区17日-19日KPI指标统计表-0717至0719.xlsx", this.kpiDao);
        daoMapper.put("13.tbPRB-表13优化区17日-19日每PRB干扰查询-15分钟.xlsx", this.prbDao);

        List<Integer> list = new ArrayList<>();

        for(String tableName: tableNames){
            try {
                ProcessExcelUtil.importData(tableName, daoMapper.get(tableName), daoMapper.get(tableName).getAllColumnName());
                list.add(0);
            }catch (Exception e){
                e.printStackTrace();
                list.add(-1);
            }
        }

        return list;
    }
}
