package myj2ee.dao;
import myj2ee.bean.C2i;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;


public interface C2iDao extends BaseDao{

    @Override
    default public int insert50(List<List<Object>> lists, List<String> columns){
        return addC2i(lists, columns);
    }

    public Integer addC2i(@Param("c2is") List<List<Object>> c2is, @Param("columns") List<String> columns);

    @Override
    default public void export(ResultHandler<Map<String, Object>> handler) throws RuntimeException{getAllC2i( handler);}

    public void getAllC2i(ResultHandler<Map<String, Object>> handler) throws RuntimeException;


}
