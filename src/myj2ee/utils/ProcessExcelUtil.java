package myj2ee.utils;

import myj2ee.common.Common;
import myj2ee.dao.BaseDao;
import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class ProcessExcelUtil {
    /**
     * 解析每个sheet页数据
     *
     * @param styles    样式
     * @param strings
     * @param sheetInputStream  输入流
     * @param saxSheetContentsHandler   读取excel的实际操作类
     * @throws Exception
     */
    private static void processSheet(StylesTable styles, ReadOnlySharedStringsTable strings, InputStream sheetInputStream, SaxSheetContentsHandler saxSheetContentsHandler)
            throws Exception {
        try {
            XMLReader sheetParser = SAXHelper.newXMLReader();
            sheetParser.setContentHandler(new XSSFSheetXMLHandler(styles, strings, saxSheetContentsHandler, false));
            sheetParser.parse(new InputSource(sheetInputStream));
        } catch (Exception e) {
            throw e;
        } finally {
            if (Objects.nonNull(sheetInputStream)) {
                sheetInputStream.close();
            }
        }
    }

    public static void importData(String filename, BaseDao baseDao, List<String> colNames) throws Exception {

        InputStream in = new FileInputStream(Common.importPath + filename);
        OPCPackage pkg = OPCPackage.open(in);
        XSSFReader xssfReader = new XSSFReader(pkg);
        StylesTable styles = xssfReader.getStylesTable();
        ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(pkg);
        Iterator<InputStream> iterators = xssfReader.getSheetsData();
        int sheetCount = 1;

        //对每个sheet进行读取
        while (iterators.hasNext()) {
            List<List<String>> temp50row = new ArrayList<>();
            SaxSheetContentsHandler sheetHandler = new SaxSheetContentsHandler(temp50row, baseDao, filename, colNames);
            processSheet(styles, strings, iterators.next(), sheetHandler);
            //插入剩余的记录
            if(temp50row != null && temp50row.size() > 0){
                baseDao.insert50(ColumnParser.parse(temp50row, filename), colNames);
            }
            sheetCount = sheetCount + 1;
        }
    }
}
