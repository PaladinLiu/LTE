package myj2ee.service;

import javafx.util.Pair;
import myj2ee.dao.KPIDao;
import myj2ee.utils.ImgGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KPIService {

    @Autowired
    private KPIDao kpiDao;

    private Map<String, String> attrToCol;

    public KPIService(){
        initializeAttrToCol();
    }

    private void initializeAttrToCol(){
        attrToCol = new HashMap<>();
        //添加属性与列名的映射
        attrToCol.put("RRC连接建立完成次数(无)", "RRC_success_times");
        attrToCol.put("RRC连接请求次数(包括重发)(无)", "RRC_total_times");
        attrToCol.put("RRC建立成功率qf(%)", "RRC_success_rate");
        attrToCol.put("E-RAB建立成功总次数(无)", "ERAB_success_times");
        attrToCol.put("E-RAB建立尝试总次数(无)", "ERAB_total_times");
        attrToCol.put("E-RAB建立成功率2(%)", "ERAB_success_rate");
        attrToCol.put("eNodeB触发的E-RAB异常释放总次数(无)", "ERAB_abnormal_times_enode");
        attrToCol.put("小区切换出E-RAB异常释放总次数(无)", "ERAB_abnormal_times_community");
        attrToCol.put("E-RAB掉线率(新)(%)", "ERAB_abnormal_rate");
        attrToCol.put("无线接通率ay(%)", "unline_success_rate");
        attrToCol.put("eNodeB发起的S1 RESET导致的UE Context释放次数(无)", "UE_release_times_enode");
        attrToCol.put("UE Context异常释放次数(无)", "UE_abnormal_release_times");
        attrToCol.put("UE Context建立成功总次数(无)", "UE_success_times");
        attrToCol.put("无线掉线率(%)", "unline_failed_rate");
        attrToCol.put("eNodeB内异频切换出成功次数(无)", "diff_frequency_success_times_in");
        attrToCol.put("eNodeB内异频切换出尝试次数(无)", "diff_frequency_total_times_in");
        attrToCol.put("eNodeB内同频切换出成功次数(无)", "simu_frequency_success_times_in");
        attrToCol.put("eNodeB内同频切换出尝试次数(无)", "simu_frequency_total_times_in");
        attrToCol.put("eNodeB间异频切换出成功次数(无)", "diff_frequency_success_times_among");
        attrToCol.put("eNodeB间异频切换出尝试次数(无)", "diff_frequency_total_times_among");
        attrToCol.put("eNodeB间同频切换出成功次数(无)", "simu_frequency_success_times_among");
        attrToCol.put("eNodeB间同频切换出尝试次数(无)", "simu_frequency_total_times_among");
        attrToCol.put("eNB内切换成功率(%)", "eNB_switch_success_rate_in");
        attrToCol.put("eNB间切换成功率(%)", "eNB_switch_success_rate_among");
        attrToCol.put("同频切换成功率zsp(%)", "simu_frequency_switch_success_rate");
        attrToCol.put("异频切换成功率zsp(%)", "diff_frequency_switch_success_rate");
        attrToCol.put("切换成功率(%)", "switch_success_rate");
        attrToCol.put("小区PDCP层所接收到的上行数据的总吞吐量(比特)", "PDCP_up_throughput");
        attrToCol.put("小区PDCP层所发送的下行数据的总吞吐量(比特)", "PDCP_down_throughput");
        attrToCol.put("RRC重建请求次数(无)", "RRC_relink_times");
        attrToCol.put("RRC连接重建比率(%)", "RRC_relink_rate");
        attrToCol.put("通过重建回源小区的eNodeB间同频切换出执行成功次数(无)", "simu_frequency_switch_times_among");
        attrToCol.put("通过重建回源小区的eNodeB间异频切换出执行成功次数(无)", "diff_frequency_switch_times_among");
        attrToCol.put("通过重建回源小区的eNodeB内同频切换出执行成功次数(无)", "simu_frequency_switch_times_in");
        attrToCol.put("通过重建回源小区的eNodeB内异频切换出执行成功次数(无)", "diff_frequency_switch_times_in");
        attrToCol.put("eNB内切换出成功次数(次)", "eNB_switch_success_times");
        attrToCol.put("eNB内切换出请求次数(次)", "eNB_switch_total_times");

    }

    public File getKPIAttributeByCellName(String cellName, String attribute, Timestamp startTime, Timestamp endTime){

        String colName = attrToCol.get(attribute);
        List<Map<String, Object>> res = kpiDao.getKPIAttributeByCellName(cellName, colName, startTime, endTime);

        List<Pair<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < res.size(); i++){
            data.add(new Pair<String, Object>(res.get(i).get("start_time").toString(), res.get(i).get(colName)));
        }

        File img = ImgGenerator.generate(data, "在"+startTime+"到"+endTime+"之间小区"+cellName +"的"+attribute+"变化","日期", attribute);

        return img;
    }

    public List<String> getAllCellNames(){
        return kpiDao.getAllCellNames();
    }

}
