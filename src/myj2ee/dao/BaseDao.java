package myj2ee.dao;

import java.util.List;

public interface BaseDao {
    public int insert50(List<List<Object>> lists, List<String> columns);
    public List<String> getAllColumnName();
}
