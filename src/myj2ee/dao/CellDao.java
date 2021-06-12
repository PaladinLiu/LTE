package myj2ee.dao;
import myj2ee.bean.Cell;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;


public interface CellDao extends BaseDao{

    @Override
    default public int insert50(List<List<Object>> lists, List<String> columns){
        return addCell(lists, columns);
    }

    public int addCell(@Param("cells") List<List<Object>> cells, @Param("columns") List<String> columns);

    @Override
    default public void export(ResultHandler<Map<String, Object>> handler) throws RuntimeException {getAllCell( handler);}

    public void getAllCell(ResultHandler<Map<String, Object>> handler) throws RuntimeException;

    //获取所有小区或基站的id或名字
    public List<String> getAllSectorId();
    public List<String> getAllSectorName();
    public List<Integer> getAllENODEBID();
    public List<String> getAllENODEBNAME();

    //根据小区或基站的id或名字查询一个或小区的信息
    public Cell getCellbySectorID(String SECTOR_ID);
    public Cell getCellbySectorName(String SECTOR_NAME);
    public List<Cell> getCellbyENODEBID(Integer ENODEBID);
    public List<Cell> getCellbyENODEBNAME(String ENODEB_NAME);

}
