package myj2ee.dao;
import myj2ee.bean.C2inew;
import org.apache.ibatis.annotations.Param;
import java.util.List;


public interface C2inewDao extends BaseDao{

    default public int insert50(List<List<Object>> lists, List<String> columns){
        return addC2inew(lists, columns);
    }
    public Integer addC2inew(@Param("c2inews") List<List<Object>> c2inews, @Param("columns") List<String> columns);
    public Integer deleteC2inew(String SCELL, String NCELL);
    public List<C2inew> getAllC2inew();
    public List<C2inew> getC2inew(String SCELL, String NCELL);
    public List<String> getAllColumnName();
}
