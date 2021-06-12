package myj2ee.dao;

import myj2ee.bean.KPI;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface KPIDao extends BaseDao{

    @Override
    default public int insert50(List<List<Object>> lists, List<String> columns){ return addKPI(lists, columns);}

    public int addKPI(@Param("kpis") List<List<Object>> kpis, @Param("columns") List<String> columns);

    @Override
    default public void export(ResultHandler<Map<String, Object>> handler) throws RuntimeException{getAllKPI( handler);}

    public void getAllKPI(ResultHandler<Map<String, Object>> handler) throws RuntimeException;

    //获取所有小区名字
    public List<String> getAllCellNames();

    /**
     *
     * @param cellName  小区名
     * @param colName   某个属性对应的列名
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return  返回某时间段某小区的某属性的所有值
     */
    public List<Map<String, Object>> getKPIAttributeByCellName(
            @Param("cellName") String cellName,@Param("colName") String colName,
            @Param("startTime") Timestamp startTime,@Param("endTime") Timestamp endTime);

}
