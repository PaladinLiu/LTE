package myj2ee.dao;
import myj2ee.bean.C2i3;
import java.util.List;


public interface C2i3Dao {


    public Integer addC2i3(C2i3 c2i3);
    public Integer deleteC2i3(String acell, String bcell, String ccell);
    public List<C2i3> getAllC2i3();
    public List<C2i3> getC2i3(String acell, String bcell, String ccell);
}
