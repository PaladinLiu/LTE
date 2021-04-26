package myj2ee.dao;

import myj2ee.bean.MROData;

import java.util.List;

public interface MRODataDao {
    public Integer addMROData(MROData mrodata);
    public Integer deleteMROData(String TimeStamp, String ServingSector, String interferingSector);
    public List<MROData> getAllMROData();
    public List<MROData> getMROData(String TimeStamp, String ServingSector, String interferingSector);
}
