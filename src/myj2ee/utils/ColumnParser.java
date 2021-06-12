package myj2ee.utils;

import myj2ee.common.Common;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 列数据类型转换器
 */
public class ColumnParser {

    public static int stringSubA(String s){
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
//    5表示datetime
//    6表示timestamp
    private static int typeOfCol(String tableName, int col){
        if(tableName.equals("1.tbCell.csv")){
            if(col == stringSubA("d") || (col >= stringSubA("f") && col <= stringSubA("j"))){
                return 1;
            }else if((col >= stringSubA("l") && col <= stringSubA("m")) || (col >= stringSubA("o") && col <= stringSubA("s"))){
                return 3;
            }else {
                return 0;
            }
        }else if(tableName.equals("9.tbMROData.xlsx")){
            if(col == 3 || col == 4){
                return 3;
            }else if(col == 5){
                return 1;
            }else if(col == 6){
                return 2;
            }else if(col == 0){
                return 6;
            } else {
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
            if(col <= 3 && col >= 1){
                return 0;
            }else if(col == stringSubA("g") || col == stringSubA("j") || col == stringSubA("m") || col == stringSubA("n") ||
                    col == stringSubA("r") || (col >= stringSubA("aa") && col <= stringSubA("ae") || col == stringSubA("ai"))){
                return 3;
            }else if(col == stringSubA("af") || col == stringSubA("ag")){
                return 4;
            }else if(col == 0){
                return 5;
            } else {
                return 1;
            }
        }else if(tableName.equals("13.tbPRB-表13优化区17日-19日每PRB干扰查询-15分钟.xlsx")){
            if(col <= 3 && col >= 1){
                return 0;
            }else if(col == 0){
                return 5;
            } else {
                return 1;
            }
        }

        return -1;
    }

    public static List<List<Object>> parse(List<List<String>> content, String tableName){
        List<List<Object>> lists = new ArrayList<>(50);

        for(int i = 0; i < content.size(); i++){
            List<Object> list = new ArrayList<>();
            List<String> row = content.get(i);
            for(int j = 0; j < row.size(); j++){
                if(row.get(j).equals("NIL")){
                    list.add(null);
                }else {
                    switch (typeOfCol(tableName, j)){
                        case 0:list.add(row.get(j));break;
                        case 1:list.add(Common.parseInt(row.get(j), 0));break;
                        case 2:list.add(Common.parseShort(row.get(j), (short) 0));break;
                        case 3:list.add(Common.parseFloat(row.get(j), 0.0f));break;
                        case 4:list.add(Common.parseBigDecimal(row.get(j), new BigDecimal(0)));break;
                        case 5:list.add(Timestamp.valueOf(Common.datetimeStringTransfer(row.get(j))));break;
                        case 6:list.add(Timestamp.valueOf(row.get(j).replaceAll("T", " ")));break;
                        default: list.add(null);
                    }
                }
            }
            lists.add(list);
        }

        return lists;
    }
}
