package myj2ee.dao;
import myj2ee.bean.MROData;
import org.apache.ibatis.annotations.Param;
import java.util.List;


public interface MRODataDao extends BaseDao{

    default public int insert50(List<List<Object>> lists, List<String> columns){
        return addMROData(lists, columns);
    }
    public int addMROData(@Param("mrodatas") List<List<Object>> mrodatas, @Param("columns") List<String> columns);
    public Integer deleteMROData(String TimeStamp, String ServingSector, String interferingSector);
    public List<MROData> getAllMROData();
    public List<MROData> getMROData(String TimeStamp, String ServingSector, String interferingSector);
    public List<String> getAllColumnName();
}
