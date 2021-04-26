package myj2ee.dao;
import myj2ee.bean.MROData;
import org.apache.ibatis.annotations.Param;
import java.util.List;


public interface MRODataDao {
    public Integer addMROData(@Param("mrodatas")List<List<Object>> mrodatas, @Param("columns")List<String> columns);
    public Integer deleteMROData(String TimeStamp, String ServingSector, String interferingSector);
    public List<MROData> getAllMROData();
    public List<MROData> getMROData(String TimeStamp, String ServingSector, String interferingSector);
    public List<String> getAllColumnName();
}
