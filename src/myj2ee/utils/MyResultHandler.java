package myj2ee.utils;

import myj2ee.common.Common;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

/**
 * 自定义查询数据操作类
 * @param <T>
 */
public class MyResultHandler<T extends Map> implements ResultHandler<T> {

    private List<String> colNames;

    //当前导出的记录数
    private int rowCount;

    private int rowTotal;

    //excel文件
    private SXSSFWorkbook workbook;

    //表1
    private SXSSFSheet sheet;

    private String filename;

    /**
     * 构造方法
     * @param colNames  所有列名
     * @param rowTotal  记录总数
     * @param filename  导出文件名
     */
    public MyResultHandler(List<String> colNames, int rowTotal, String filename) {
        this.colNames = colNames;
        this.rowCount = 0;
        this.workbook = null;
        this.sheet = null;
        this.rowTotal = rowTotal;
        this.filename = filename;
        System.setProperty("java.io.tmpdir", Common.exportPath + "tempFile/");

    }

    //删除临时文件
    private void deleteTempFile(){
        File dir = new File(Common.exportPath + "tempFile/");
        File[] files = dir.listFiles();
        for(File file: files){
            deleteFile(file);
        }
    }

    private void deleteFile(File file){
        if(file.isDirectory()){
            File[] content = file.listFiles();
            for (File item: content){
                deleteFile(item);
            }
            file.delete();
        }else {
            file.delete();
        }
    }

    @Override
    public void handleResult(ResultContext<? extends T> resultContext){

        //若为第一条记录，则先将表头导出
        if(rowCount == 0){
            workbook = new SXSSFWorkbook(1000);
            sheet = workbook.createSheet("sheet1");
            Row row = sheet.createRow(0);

            for(int i = 0; i < colNames.size(); i++){
                row.createCell(i).setCellValue(colNames.get(i));
            }
        }

        //将查询的每一条记录导出到一行里
        Row row = sheet.createRow(rowCount + 1);
        Map<String, Object> result = (Map<String, Object>) resultContext.getResultObject();

        for(int i = 0; i < colNames.size(); i++){
            Object obj = result.get(colNames.get(i));
            if(obj != null){
                row.createCell(i).setCellValue(result.get(colNames.get(i)).toString());
            }else {
                row.createCell(i).setCellValue("NIL");
            }
        }
        rowCount++;
        System.out.println(rowCount+":"+resultContext.getResultObject());

        //若为最后一条记录,刷新缓存,导出剩余的记录,删除临时文件
        if(rowCount == rowTotal){

            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(new File(Common.exportPath + filename));
                sheet.flushRows();
                workbook.write(outputStream);
                outputStream.close();
                deleteTempFile();
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
