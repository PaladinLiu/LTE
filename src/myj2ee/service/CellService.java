package myj2ee.service;

import myj2ee.bean.Cell;
import myj2ee.dao.CellDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CellService {

    @Autowired
    private CellDao cellDao;

    public List<String> getAllCellId(){
        return cellDao.getAllSectorId();
    }

    public List<String> getAllCellName(){
        return cellDao.getAllSectorName();
    }

    public List<Integer> getAllEnodebId(){
        return cellDao.getAllENODEBID();
    }

    public List<String> getAllEnodebName(){
        return cellDao.getAllENODEBNAME();
    }

    public Cell getCellByCellId(String id){
        return cellDao.getCellbySectorID(id);
    }

    public Cell getCellByCellName(String name){
        return cellDao.getCellbySectorName(name);
    }

    public List<Cell> getCellByEnodebId(int id){
        return cellDao.getCellbyENODEBID(id);
    }

    public List<Cell> getCellByEnodebName(String name){
        return cellDao.getCellbyENODEBNAME(name);
    }

}
