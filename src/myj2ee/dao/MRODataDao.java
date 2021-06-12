package myj2ee.dao;
import myj2ee.bean.C2inew;
import myj2ee.bean.MROData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;


public interface MRODataDao extends BaseDao{

    @Override
    default public int insert50(List<List<Object>> lists, List<String> columns){
        return addMROData(lists, columns);
    }

    public int addMROData(@Param("mrodatas") List<List<Object>> mrodatas, @Param("columns") List<String> columns);

    @Override
    default public void export(ResultHandler<Map<String, Object>> handler) throws RuntimeException{
        getAllMROData( handler);
    }

    public void getAllMROData(ResultHandler<Map<String, Object>> handler) throws RuntimeException;

    //根据tbMROdata的信息计算某相邻小区对的c2i平均值与标准差
    public List<Map<String, Object>> calculateC2I();
}
