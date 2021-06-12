package myj2ee.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface PRBNewDao extends BaseDao{

    @Override
    default public void export(ResultHandler<Map<String, Object>> handler) throws RuntimeException{getAllPRB(handler);};

    public void getAllPRB(ResultHandler<Map<String, Object>> handler) throws RuntimeException;

    public int generateNew(@Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime, @Param("columns") List<String> columns) throws RuntimeException;

    public List<Map<String, Object>> getPRBAttributeByStationName(
            @Param("stationName") String stationName,@Param("colName") String colName,
            @Param("startTime") Timestamp startTime,@Param("endTime") Timestamp endTime);

    //获取所有基站名
    public List<String> getAllStationNames();
}
