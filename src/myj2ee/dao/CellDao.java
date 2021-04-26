package myj2ee.dao;
import myj2ee.bean.Cell;
import java.util.List;


public interface CellDao {
    public Integer addCell(Cell cell);
    public Integer deleteCell();
    public List<Cell> getAllCell();
    public List<Cell> getCell();
}
