package myj2ee.utils;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;
import myj2ee.common.Common;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * 折线图生成器
 */
public class ImgGenerator {
    public static File generate(List<Pair<String, Object>> data, String title, String Xlabol, String Ylabol) {

        //折线图数据
        DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();

        //柱状图数据
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //添加数据

        Number min = 0;
        Number max = 1;

        if(data != null && data.size() != 0){
            max = min = (Number) data.get(0).getValue();
            for(int i = 0; i < data.size(); i++){
                Pair<String, Object> pair = data.get(i);
                Number temp = (Number) pair.getValue();
                max = max.floatValue() < temp.floatValue() ? temp : max;
                min = min.floatValue() > temp.floatValue() ? temp : min;
                lineDataset.addValue(temp, "", pair.getKey());
//            dataset.addValue(temp, "", pair.getKey());
            }
        }

        //生成的柱状图
        JFreeChart chart = ChartFactory.createBarChart3D(
                title,
                Xlabol,//X轴的标签
                Ylabol,//Y轴的标签
                dataset, //图标显示的数据集合
                PlotOrientation.VERTICAL, //图像的显示形式（水平或者垂直）
                false,//是否显示子标题
                false,//是否生成提示的标签
                false); //是否生成URL链接

        /*
         * 处理图形上的乱码
         */

        //处理主标题的乱码
        chart.getTitle().setFont(new Font("黑体",Font.BOLD,18));

        //获取图表区域对象
        CategoryPlot categoryPlot = (CategoryPlot)chart.getPlot();

        //获取X轴的对象
        CategoryAxis3D categoryAxis3D = (CategoryAxis3D)categoryPlot.getDomainAxis();

        //获取Y轴的对象
        NumberAxis3D numberAxis3D = (NumberAxis3D)categoryPlot.getRangeAxis();

        //处理X轴上的乱码
        categoryAxis3D.setTickLabelFont(new Font("黑体",Font.BOLD,10));

        //处理X轴外的乱码
        categoryAxis3D.setLabelFont(new Font("黑体",Font.BOLD,10));

        //处理Y轴上的乱码
        numberAxis3D.setTickLabelFont(new Font("黑体",Font.BOLD,10));

        //处理Y轴外的乱码
        numberAxis3D.setLabelFont(new Font("黑体",Font.BOLD,10));

        if(min.floatValue() != max.floatValue()){
            numberAxis3D.setRange(min.floatValue(), max.floatValue());
        }else {
            numberAxis3D.setRange(min.floatValue()-min.floatValue()*0.1, max.floatValue()+max.floatValue()*0.1);
        }

//        //自定义Y轴上显示的刻度，以10作为1格
//        numberAxis3D.setAutoTickUnitSelection(false);
//        NumberTickUnit unit = new NumberTickUnit(1);
//        numberAxis3D.setTickUnit(unit);


        //获取绘图区域对象
        BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot.getRenderer();

        //设置柱形图的宽度
//        barRenderer3D.setMaximumBarWidth(0.07);

        //在图形上显示数字
        barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        barRenderer3D.setBaseItemLabelsVisible(true);
        barRenderer3D.setBaseItemLabelFont(new Font("宋体",Font.BOLD,10));

        /*
         * 放折线图数据
         */
        categoryPlot.setDataset(1, lineDataset);
        //设置折线
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
        lineandshaperenderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());
        categoryPlot.setRenderer(1, lineandshaperenderer);
        // 柱状图和纵轴紧靠
        categoryAxis3D.setLowerMargin(0.0);

        categoryAxis3D.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        //折线在柱面前面显示
        categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);


        File file = new File(Common.exportPath + "img/a.png");
        try {
            ChartUtilities.saveChartAsJPEG(file, chart, 1200, 900);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

}
