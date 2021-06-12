package myj2ee.dao;
import myj2ee.bean.C2inew;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;


public interface C2inewDao extends BaseDao{

    @Override
    default public int insert50(List<List<Object>> lists, List<String> columns){
        return addC2inew(lists, columns);
    }

    public int addC2inew(@Param("c2inews") List<List<Object>> c2inews, @Param("columns") List<String> columns);

    @Override
    default public void export(ResultHandler<Map<String, Object>> handler) throws RuntimeException {
        getAllC2inew( handler);
    }

    public void getAllC2inew(ResultHandler<Map<String, Object>> handler) throws RuntimeException;

    /**
     * 根据传进来的数据生成表
     * @param c2is  计算出来的所有c2i的数据
     * @return 生产记录的数量
     * @throws RuntimeException
     */
    public int generateNew(@Param("c2is") List<Map<String, Object>> c2is) throws RuntimeException;

}
