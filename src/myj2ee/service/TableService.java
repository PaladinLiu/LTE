package myj2ee.service;

import myj2ee.common.Common;
import myj2ee.dao.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
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

    @Transactional
    public List<Integer> exportTables(List<String> tableNames){
        return null;
    }

    @Transactional
    public List<Integer> importTables(List<String> tableNames){
        Map<String, BaseDao> daoMapper = new HashMap<>();
        daoMapper.put("1.tbCell.csv", this.cellDao);
        daoMapper.put("9.tbMROData.csv", this.mroDataDao);
        daoMapper.put("10.tbC2I.xlsx", this.c2iDao);

        String dirPath = Common.importPath;
        List<Integer> list = new ArrayList<>();
        System.out.println(tableNames);
        for(String tableName: tableNames){
            try {
                XSSFWorkbook workbook =new XSSFWorkbook(new BufferedInputStream(new FileInputStream(new File(dirPath + tableName))));
                XSSFSheet sheet = workbook.getSheetAt(0);

                BaseDao dao = daoMapper.get(tableName);

                List<String> colmuns = dao.getAllColumnName();
                System.out.println(colmuns);

                int rows = sheet.getPhysicalNumberOfRows();
                System.out.println(rows);
                for(int i = 1; i < rows; i = Math.min(rows, i + 50)){
                    String[][] content = read50line(sheet, i, colmuns.size());
//                    for(int x1 = 0; x1 < content.length; x1++){
//                        for (int x2 = 0; x2 < content[x1].length; x2++){
//                            System.out.print(content[x1][x2] + " ");
//                        }
//                        System.out.println();
//                    }
                    List<List<Object>> parsedContent = parse(content, tableName);
                    System.out.println(1);
                    dao.insert50(parsedContent, colmuns);
                }
                list.add(0);
                workbook.close();

            }catch (IOException e){
                e.printStackTrace();
                list.add(-1);
            }
        }

        return list;
    }

    private String[][] read50line(XSSFSheet sheet, int start, int cols){
        int rows = sheet.getPhysicalNumberOfRows();
        String[][] content = new String[Math.min(50, rows - start)][cols];
        for(int i = 0; i < 50 && i < rows - start; i++){
            System.out.println(2);
            XSSFRow row = sheet.getRow(i + start);
            for(int j = 0; j < row.getPhysicalNumberOfCells() && j < cols; j++){
                row.getCell(j).setCellType(CellType.STRING);
                content[i][j] = row.getCell(j).getStringCellValue();
            }
            for(int j = row.getPhysicalNumberOfCells(); j < cols; j++){
                content[i][j] = "NIL";
            }
        }

        return content;
    }

    private int stringSubA(String s){
        s = s.toLowerCase();
        if(s.length() == 1){
            return s.charAt(0) - 'a';
        }else {
            int time = 'z' - 'a' + 1;
            int weight = time;
            int sum = s.charAt(s.length() - 1) - 'a';
            for(int i = s.length() - 2; i >= 0; i--){
                sum += (s.charAt(i) - 'a' + 1) * weight;
                weight *= time;
            }

            return sum;
        }
    }

//    0表示string
//    1表示int
//    2表示short
//    3表示float
//    4表示BigDecimal
    private int typeOfCol(String tableName, int col){
        if(tableName.equals("1.tbCell.csv")){
            if(col == stringSubA("d") || (col >= stringSubA("f") && col <= stringSubA("j"))){
                return 1;
            }else if((col >= stringSubA("l") && col <= stringSubA("m")) || (col >= stringSubA("o") && col <= stringSubA("s"))){
                return 3;
            }else {
                return 0;
            }
        }else if(tableName.equals("9.tbMROData.csv")){
            if(col == 3 || col == 4){
                return 3;
            }else if(col == 5){
                return 1;
            }else if(col == 6){
                return 2;
            }else {
                return 0;
            }
        }else if(tableName.equals("10.tbC2I.xlsx")){
            if(col == 3 || col == 6 || col == 7){
                return 1;
            }else if(col == 4 || col == 5){
                return 3;
            }else {
                return 0;
            }

        }else if(tableName.equals("12.tbCellKPI-优化区17日-19日KPI指标统计表-0717至0719.xlsx")){
            if(col <= 3 && col >= 0){
                return 0;
            }else if(col == stringSubA("g") || col == stringSubA("j") || col == stringSubA("m") || col == stringSubA("n") ||
                    col == stringSubA("r") || (col >= stringSubA("aa") && col <= stringSubA("ae") || col == stringSubA("ai"))){
                return 3;
            }else if(col == stringSubA("af") || col == stringSubA("ag")){
                return 4;
            }else {
                return 1;
            }
        }else if(tableName.equals("13.tbPRB-表13优化区17日-19日每PRB干扰查询-15分钟.xlsx")){
            if(col <= 3 && col >= 0){
                return 0;
            }else {
                return 1;
            }
        }

        return -1;
    }

    private List<List<Object>> parse(String[][] content, String tableName){
        List<List<Object>> lists = new ArrayList<>(50);
        for(int i = 0; i < content.length; i++){
            List<Object> list = new ArrayList<>();
            for(int j = 0; j < content[i].length; j++){
                if(content[i][j].equals("NIL")){
                    list.add(null);
                }else {
                    switch (typeOfCol(tableName, j)){
                        case 0:list.add(content[i][j]);break;
                        case 1:list.add(Common.parseInt(content[i][j], 0));break;
                        case 2:list.add(Common.parseShort(content[i][j], (short) 0));break;
                        case 3:list.add(Common.parseFloat(content[i][j], 0.0f));break;
                        case 4:list.add(Common.parseBigDecimal(content[i][j], new BigDecimal(0)));break;
                        default: return null;
                    }
                }
            }
            lists.add(list);
        }

        return lists;
    }
}
