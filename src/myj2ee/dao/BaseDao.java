package myj2ee.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;

public interface BaseDao {

    /**
     * 插入50条记录
     * @param lists 插入的内容
     * @param columns 所有列名
     * @return 实际插入记录的数量
     */
    public int insert50(List<List<Object>> lists, List<String> columns);

    /**
     * 获取所有列名
     * @return
     */
    public List<String> getAllColumnName();

    /**
     * 获取记录的数量(行数)
     * @return
     */
    public Integer getRowCount();

    /**
     * 导出表
     * @param handler 导出数据实际执行类
     * @throws RuntimeException 抛出导出时的异常
     */
    public void export(ResultHandler<Map<String, Object>> handler) throws RuntimeException;

    /**
     * 清空表
     */
    public void clear();
}
