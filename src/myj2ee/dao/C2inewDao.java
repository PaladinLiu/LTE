package myj2ee.dao;
import myj2ee.bean.C2inew;
import java.util.List;


public interface C2inewDao {
    public Integer addC2inew(C2inew c2inew);
    public Integer deleteC2inew(String SCELL, String NCELL);
    public List<C2inew> getAllC2inew();
    public List<C2inew> getC2inew(String SCELL, String NCELL);
}
