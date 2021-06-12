package myj2ee.common;


import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public static ServletContext context = ContextLoader.getCurrentWebApplicationContext().getServletContext();
    public static String importPath = context.getInitParameter("ImportPath");
    public static String exportPath = context.getInitParameter("ExportPath");

    public static int parseInt(String s, int defaultValue){
        try {
            return Integer.parseInt(s);
        }catch (NumberFormatException e){
            return defaultValue;
        }
    }

    public static short parseShort(String s, short defaultValue){
        try {
            return Short.parseShort(s);
        }catch (NumberFormatException e){
            return defaultValue;
        }
    }

    public static float parseFloat(String s, float defaultValue){
        try {
            return Float.parseFloat(s);
        }catch (NumberFormatException e){
            return defaultValue;
        }
    }

    public static BigDecimal parseBigDecimal(String s, BigDecimal defaultValue){
        try {
            return new BigDecimal(s);
        }catch (NumberFormatException e){
            return defaultValue;
        }
    }

    public static Date paserDate(String s, Date defaultValue){
        try {
            return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(s);
        }catch (ParseException e){
            return defaultValue;
        }
    }

    public static String datetimeStringTransfer(String s){
        String[] strings = s.split(" ");
        String[] dateString = strings[0].split("/");
        String res = dateString[2] + "-" + dateString[0] + "-" + dateString[1] + " "
                    +strings[1];

        return res;
    }
}
