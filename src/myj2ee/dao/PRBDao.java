package myj2ee.dao;

import myj2ee.bean.KPI;
import myj2ee.bean.PRB;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface PRBDao extends BaseDao{

    @Override
    default public int insert50(List<List<Object>> lists, List<String> columns){ return addPRB(lists, columns);}

    public int addPRB(@Param("prbs") List<List<Object>> prbs, @Param("columns") List<String> columns);

    @Override
    default public void export(ResultHandler<Map<String, Object>> handler) throws RuntimeException{getAllPRB( handler);}

    public void getAllPRB(ResultHandler<Map<String, Object>> handler) throws RuntimeException;

    //获取最小与最大时间戳
    public Map<String, Timestamp> getLimit();
}
