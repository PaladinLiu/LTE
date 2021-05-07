package myj2ee.dao;
import myj2ee.bean.Cell;
import org.apache.ibatis.annotations.Param;
import java.util.List;


public interface CellDao extends BaseDao{

    default public int insert50(List<List<Object>> lists, List<String> columns){
        return addCell(lists, columns);
    }
    public int addCell(@Param("cells") List<List<Object>> cells, @Param("columns") List<String> columns);
    public List<Cell> getAllCell();
    public List<Cell> getCellbySectorID(String SECTOR_ID);
    public List<Cell> getCellbySectorName(String SECTOR_NAME);
    public List<Cell> getCellbyENODEBID(String ENODEBID);
    public List<Cell> getCellbyENODEBNAME(String ENODEB_NAME);
    public List<String> getAllColumnName();
}
