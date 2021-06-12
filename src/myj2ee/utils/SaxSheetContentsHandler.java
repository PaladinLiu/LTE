package myj2ee.utils;

import myj2ee.dao.BaseDao;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SaxSheetContentsHandler implements XSSFSheetXMLHandler.SheetContentsHandler{

    //一条记录的临时缓冲区
    private List<String> dataRow = new ArrayList<>(128);

    //50条记录的临时缓冲区
    private List<List<String>> temp50row;

    //当前读取的记录数
    private int rowCount = 0;

    //导入数据库表的dao
    private BaseDao dao;

    //当前行上一个读取的列号
    private int lastCol = -1;

    //当前行读取的列数
    private int colNum;

    //导入数据库表的列名
    private List<String> colNames;

    //读取的文件名
    private String filename;

    /**
     *
     * @param temp50row 50行数据的缓冲
     * @param dao       导入数据库表的dao
     * @param filename  读取的文件名
     * @param colNames  导入数据库表的列名
     */
    public SaxSheetContentsHandler(List<List<String>> temp50row, BaseDao dao, String filename, List<String> colNames){
        this.temp50row =temp50row;
        this.filename = filename;
        this.dao = dao;
        this.colNames = colNames;
        this.colNum = colNames.size();
    }

    /**
     * 每行的一开始
     * @param rowNum 当前行数
     */
    @Override
    public void startRow(int rowNum) {
        if(rowNum<1){
            return;
        }

        lastCol = -1;

        dataRow.clear();
    }


    /**
     * 每行的结束
     * @param rowNum 当前行数
     */
    @Override
    public void endRow(int rowNum) {
        if(rowNum<1){
            return;
        }

        while (lastCol < colNum - 1){
            dataRow.add("NIL");
            lastCol++;
        }

        if(!dataRow.isEmpty()){
            List<String> tempDataRow = clone(dataRow);
            temp50row.add(tempDataRow);

        }

        //满50条清空并插入
        rowCount++;
        if(rowCount % 50 == 0 && rowCount != 0){
            dao.insert50(ColumnParser.parse(temp50row, filename), colNames);
            temp50row.clear();
        }
    }

    /**
     *  每个单元格的处理
     * @param cellReference 列名   例如A,B,C等
     * @param formattedValue 单元格值 对应每个单元格的值, [^A-Za-z]:匹配所有非字母的都用""
     * 代替,因为多行Excel的列明是：A1，B1，C1，....D10等，匹配替换后每行的列名就是A,B,C等。
     * 此方法用解析每一个cell的值
     * @param comment
     */
    @Override
    public void cell(String cellReference, String formattedValue, XSSFComment comment) {

        int curCol = ColumnParser.stringSubA(cellReference.replaceAll("[^A-Za-z]",""));

        while (lastCol + 1 < curCol){
            dataRow.add("NIL");
            lastCol++;
        }

        dataRow.add(formattedValue);
        lastCol++;

        return;

    }

    @Override
    public void headerFooter(String text, boolean isHeader, String tagName) {
//        logger.debug("text: {},isHeader: {},tagName : {}",text,isHeader,tagName);
    }

    private static List<String> clone(List<String> list){
        List<String> res = new ArrayList<>(128);
        for(int i = 0; i < list.size(); i++){
            res.add(list.get(i));
        }

        return res;
    }
}
