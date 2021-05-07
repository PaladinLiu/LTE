package myj2ee.dao;
import myj2ee.bean.C2i;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface C2iDao extends BaseDao{

    default public int insert50(List<List<Object>> lists, List<String> columns){
        return addC2i(lists, columns);
    }
    public Integer addC2i(@Param("c2is") List<List<Object>> c2is, @Param("columns") List<String> columns);
    public Integer deleteC2i(String SCELL, String NCELL);
    public List<C2i> getAllC2i();
    public List<C2i> getC2i(String SCELL, String NCELL);
    public List<String> getAllColumnName();
}
