package myj2ee.dao;
import myj2ee.bean.C2i;
import java.util.List;


public interface C2iDao {
    public Integer addC2i(C2i c2i);
    public Integer deleteC2i(String SCELL, String NCELL);
    public List<C2i> getAllC2i();
    public List<C2i> getC2i(String SCELL, String NCELL);
}
