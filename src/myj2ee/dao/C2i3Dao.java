package myj2ee.dao;
import myj2ee.bean.C2i3;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;


public interface C2i3Dao extends BaseDao{

    @Override
    default public void export(ResultHandler<Map<String, Object>> handler) throws RuntimeException {getAllC2i3( handler);}

    public void getAllC2i3(ResultHandler<Map<String, Object>> handler) throws RuntimeException;

    /**
     * 生成tbc213
     * @param x 用户设定的阈值参数
     * @return 生成记录的数量
     */
    public int generate3(@Param("x") double x);

}
