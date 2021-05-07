package myj2ee.common;


import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import java.math.BigDecimal;

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
}
