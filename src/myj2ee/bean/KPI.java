package myj2ee.bean;

import org.apache.ibatis.annotations.ResultMap;

import java.math.BigDecimal;


public class KPI {
    private String startTime;                   //起始时间
    private String baseStationName;             //网元/基站名称
    private String community;                   //小区
    private String communityName;               //小区名称
    private int RRCSuccessTimes;                //RRC连接建立完成次数 (无)
    private int RRCTotalTimes;                  //RRC连接请求次数（包括重发） (无)
    private float RRCSuccessRate;               //RRC建立成功率qf (%)
    private int ERABSuccessTimes;               //E-RAB建立成功总次数 (无)
    private int ERABTotalTimes;                 //E-RAB建立尝试总次数 (无)
    private float ERABSuccessRate;              //E-RAB建立成功率2 (%)
    private int ERABAbnormalTimesEnode;         //eNodeB触发的E-RAB异常释放总次数 (无)
    private int ERABAbnormalTimesCommunity;     //小区切换出E-RAB异常释放总次数 (无)
    private float ERABAbnormalRate;             //E-RAB掉线率(新) (%)
    private float unlineSuccessRate;            //无线接通率ay (%)
    private int UEReleaseTimesEnode;            //eNodeB发起的S1 RESET导致的UE Context释放次数 (无)
    private int UEAbnormalReleaseTimes;         //UE Context异常释放次数 (无)
    private int UESuccessTimes;                 //UE Context建立成功总次数 (无)
    private float unlineFailedRate;             //无线掉线率 (%)
    private int diffFrequencySuccessTimesIn;    //eNodeB内异频切换出成功次数 (无)
    private int diffFrequencyTotalTimesIn;      //eNodeB内异频切换出尝试次数 (无)
    private int simuFrequencySuccessTimesIn;    //eNodeB内同频切换出成功次数 (无)
    private int simuFrequencyTotalTimesIn;      //eNodeB内同频切换出尝试次数 (无)
    private int diffFrequencySuccessTimesAmong; //eNodeB间异频切换出成功次数 (无)
    private int diffFrequencyTotalTimesAmong;   //eNodeB间异频切换出尝试次数 (无)
    private int simuFrequencySuccessTimesAmong; //eNodeB间同频切换出成功次数 (无)
    private int simuFrequencyTotalTimesAmong;   //eNodeB间同频切换出尝试次数 (无)
    private float eNBSwitchSuccessRateIn;       //eNB内切换成功率 (%)
    private float eNBSwitchSuccessRateAmong;    //eNB间切换成功率 (%)
    private float simuFrequencySwitchSuccessRate;//同频切换成功率zsp (%)
    private float diffFrequencySwitchSuccessRate;//异频切换成功率zsp (%)
    private float switchSuccessRate;            //切换成功率 (%)
    private BigDecimal PDCPUpThroughput;        //小区PDCP层所接收到的上行数据的总吞吐量 (比特)
    private BigDecimal PDCPDownThroughput;      //小区PDCP层所发送的下行数据的总吞吐量 (比特)
    private int RRCRelinkTimes;                 //RRC重建请求次数 (无)
    private float RRCRelinkRate;                //RRC连接重建比率 (%)
    private int simuFrequencySwitchTimesAmong;  //通过重建回源小区的eNodeB间同频切换出执行成功次数 (无)
    private int diffFrequencySwitchTimesAmong;  //通过重建回源小区的eNodeB间异频切换出执行成功次数 (无)
    private int simuFrequencySwitchTimesIn;     //通过重建回源小区的eNodeB内同频切换出执行成功次数 (无)
    private int diffFrequencySwitchTimesIn;     //通过重建回源小区的eNodeB内异频切换出执行成功次数 (无)
    private int eNBSwitchSuccessTimes;          //eNB内切换出成功次数 (次)
    private int eNBSwitchTotalTimes;            //eNB内切换出请求次数 (次)

    public KPI() {
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getBaseStationName() {
        return baseStationName;
    }

    public void setBaseStationName(String baseStationName) {
        this.baseStationName = baseStationName;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public int getRRCSuccessTimes() {
        return RRCSuccessTimes;
    }

    public void setRRCSuccessTimes(int RRCSuccessTimes) {
        this.RRCSuccessTimes = RRCSuccessTimes;
    }

    public int getRRCTotalTimes() {
        return RRCTotalTimes;
    }

    public void setRRCTotalTimes(int RRCTotalTimes) {
        this.RRCTotalTimes = RRCTotalTimes;
    }

    public float getRRCSuccessRate() {
        return RRCSuccessRate;
    }

    public void setRRCSuccessRate(float RRCSuccessRate) {
        this.RRCSuccessRate = RRCSuccessRate;
    }

    public int getERABSuccessTimes() {
        return ERABSuccessTimes;
    }

    public void setERABSuccessTimes(int ERABSuccessTimes) {
        this.ERABSuccessTimes = ERABSuccessTimes;
    }

    public int getERABTotalTimes() {
        return ERABTotalTimes;
    }

    public void setERABTotalTimes(int ERABTotalTimes) {
        this.ERABTotalTimes = ERABTotalTimes;
    }

    public float getERABSuccessRate() {
        return ERABSuccessRate;
    }

    public void setERABSuccessRate(float ERABSuccessRate) {
        this.ERABSuccessRate = ERABSuccessRate;
    }

    public int getERABAbnormalTimesEnode() {
        return ERABAbnormalTimesEnode;
    }

    public void setERABAbnormalTimesEnode(int ERABAbnormalTimesEnode) {
        this.ERABAbnormalTimesEnode = ERABAbnormalTimesEnode;
    }

    public int getERABAbnormalTimesCommunity() {
        return ERABAbnormalTimesCommunity;
    }

    public void setERABAbnormalTimesCommunity(int ERABAbnormalTimesCommunity) {
        this.ERABAbnormalTimesCommunity = ERABAbnormalTimesCommunity;
    }

    public float getERABAbnormalRate() {
        return ERABAbnormalRate;
    }

    public void setERABAbnormalRate(float ERABAbnormalRate) {
        this.ERABAbnormalRate = ERABAbnormalRate;
    }

    public float getUnlineSuccessRate() {
        return unlineSuccessRate;
    }

    public void setUnlineSuccessRate(float unlineSuccessRate) {
        this.unlineSuccessRate = unlineSuccessRate;
    }

    public int getUEReleaseTimesEnode() {
        return UEReleaseTimesEnode;
    }

    public void setUEReleaseTimesEnode(int UEReleaseTimesEnode) {
        this.UEReleaseTimesEnode = UEReleaseTimesEnode;
    }

    public int getUEAbnormalReleaseTimes() {
        return UEAbnormalReleaseTimes;
    }

    public void setUEAbnormalReleaseTimes(int UEAbnormalReleaseTimes) {
        this.UEAbnormalReleaseTimes = UEAbnormalReleaseTimes;
    }

    public int getUESuccessTimes() {
        return UESuccessTimes;
    }

    public void setUESuccessTimes(int UESuccessTimes) {
        this.UESuccessTimes = UESuccessTimes;
    }

    public float getUnlineFailedRate() {
        return unlineFailedRate;
    }

    public void setUnlineFailedRate(float unlineFailedRate) {
        this.unlineFailedRate = unlineFailedRate;
    }

    public int getDiffFrequencySuccessTimesIn() {
        return diffFrequencySuccessTimesIn;
    }

    public void setDiffFrequencySuccessTimesIn(int diffFrequencySuccessTimesIn) {
        this.diffFrequencySuccessTimesIn = diffFrequencySuccessTimesIn;
    }

    public int getDiffFrequencyTotalTimesIn() {
        return diffFrequencyTotalTimesIn;
    }

    public void setDiffFrequencyTotalTimesIn(int diffFrequencyTotalTimesIn) {
        this.diffFrequencyTotalTimesIn = diffFrequencyTotalTimesIn;
    }

    public int getSimuFrequencySuccessTimesIn() {
        return simuFrequencySuccessTimesIn;
    }

    public void setSimuFrequencySuccessTimesIn(int simuFrequencySuccessTimesIn) {
        this.simuFrequencySuccessTimesIn = simuFrequencySuccessTimesIn;
    }

    public int getSimuFrequencyTotalTimesIn() {
        return simuFrequencyTotalTimesIn;
    }

    public void setSimuFrequencyTotalTimesIn(int simuFrequencyTotalTimesIn) {
        this.simuFrequencyTotalTimesIn = simuFrequencyTotalTimesIn;
    }

    public int getDiffFrequencySuccessTimesAmong() {
        return diffFrequencySuccessTimesAmong;
    }

    public void setDiffFrequencySuccessTimesAmong(int diffFrequencySuccessTimesAmong) {
        this.diffFrequencySuccessTimesAmong = diffFrequencySuccessTimesAmong;
    }

    public int getDiffFrequencyTotalTimesAmong() {
        return diffFrequencyTotalTimesAmong;
    }

    public void setDiffFrequencyTotalTimesAmong(int diffFrequencyTotalTimesAmong) {
        this.diffFrequencyTotalTimesAmong = diffFrequencyTotalTimesAmong;
    }

    public int getSimuFrequencySuccessTimesAmong() {
        return simuFrequencySuccessTimesAmong;
    }

    public void setSimuFrequencySuccessTimesAmong(int simuFrequencySuccessTimesAmong) {
        this.simuFrequencySuccessTimesAmong = simuFrequencySuccessTimesAmong;
    }

    public int getSimuFrequencyTotalTimesAmong() {
        return simuFrequencyTotalTimesAmong;
    }

    public void setSimuFrequencyTotalTimesAmong(int simuFrequencyTotalTimesAmong) {
        this.simuFrequencyTotalTimesAmong = simuFrequencyTotalTimesAmong;
    }

    public float geteNBSwitchSuccessRateIn() {
        return eNBSwitchSuccessRateIn;
    }

    public void seteNBSwitchSuccessRateIn(float eNBSwitchSuccessRateIn) {
        this.eNBSwitchSuccessRateIn = eNBSwitchSuccessRateIn;
    }

    public float geteNBSwitchSuccessRateAmong() {
        return eNBSwitchSuccessRateAmong;
    }

    public void seteNBSwitchSuccessRateAmong(float eNBSwitchSuccessRateAmong) {
        this.eNBSwitchSuccessRateAmong = eNBSwitchSuccessRateAmong;
    }

    public float getSimuFrequencySwitchSuccessRate() {
        return simuFrequencySwitchSuccessRate;
    }

    public void setSimuFrequencySwitchSuccessRate(float simuFrequencySwitchSuccessRate) {
        this.simuFrequencySwitchSuccessRate = simuFrequencySwitchSuccessRate;
    }

    public float getDiffFrequencySwitchSuccessRate() {
        return diffFrequencySwitchSuccessRate;
    }

    public void setDiffFrequencySwitchSuccessRate(float diffFrequencySwitchSuccessRate) {
        this.diffFrequencySwitchSuccessRate = diffFrequencySwitchSuccessRate;
    }

    public float getSwitchSuccessRate() {
        return switchSuccessRate;
    }

    public void setSwitchSuccessRate(float switchSuccessRate) {
        this.switchSuccessRate = switchSuccessRate;
    }

    public BigDecimal getPDCPUpThroughput() {
        return PDCPUpThroughput;
    }

    public void setPDCPUpThroughput(BigDecimal PDCPUpThroughput) {
        this.PDCPUpThroughput = PDCPUpThroughput;
    }

    public BigDecimal getPDCPDownThroughput() {
        return PDCPDownThroughput;
    }

    public void setPDCPDownThroughput(BigDecimal PDCPDownThroughput) {
        this.PDCPDownThroughput = PDCPDownThroughput;
    }

    public int getRRCRelinkTimes() {
        return RRCRelinkTimes;
    }

    public void setRRCRelinkTimes(int RRCRelinkTimes) {
        this.RRCRelinkTimes = RRCRelinkTimes;
    }

    public float getRRCRelinkRate() {
        return RRCRelinkRate;
    }

    public void setRRCRelinkRate(float RRCRelinkRate) {
        this.RRCRelinkRate = RRCRelinkRate;
    }

    public int getSimuFrequencySwitchTimesAmong() {
        return simuFrequencySwitchTimesAmong;
    }

    public void setSimuFrequencySwitchTimesAmong(int simuFrequencySwitchTimesAmong) {
        this.simuFrequencySwitchTimesAmong = simuFrequencySwitchTimesAmong;
    }

    public int getDiffFrequencySwitchTimesAmong() {
        return diffFrequencySwitchTimesAmong;
    }

    public void setDiffFrequencySwitchTimesAmong(int diffFrequencySwitchTimesAmong) {
        this.diffFrequencySwitchTimesAmong = diffFrequencySwitchTimesAmong;
    }

    public int getSimuFrequencySwitchTimesIn() {
        return simuFrequencySwitchTimesIn;
    }

    public void setSimuFrequencySwitchTimesIn(int simuFrequencySwitchTimesIn) {
        this.simuFrequencySwitchTimesIn = simuFrequencySwitchTimesIn;
    }

    public int getDiffFrequencySwitchTimesIn() {
        return diffFrequencySwitchTimesIn;
    }

    public void setDiffFrequencySwitchTimesIn(int diffFrequencySwitchTimesIn) {
        this.diffFrequencySwitchTimesIn = diffFrequencySwitchTimesIn;
    }

    public int geteNBSwitchSuccessTimes() {
        return eNBSwitchSuccessTimes;
    }

    public void seteNBSwitchSuccessTimes(int eNBSwitchSuccessTimes) {
        this.eNBSwitchSuccessTimes = eNBSwitchSuccessTimes;
    }

    public int geteNBSwitchTotalTimes() {
        return eNBSwitchTotalTimes;
    }

    public void seteNBSwitchTotalTimes(int eNBSwitchTotalTimes) {
        this.eNBSwitchTotalTimes = eNBSwitchTotalTimes;
    }

    @Override
    public String toString() {
        return "KPI{" +
                "startTime='" + startTime + '\'' +
                ", baseStationName='" + baseStationName + '\'' +
                ", community='" + community + '\'' +
                ", communityName='" + communityName + '\'' +
                ", RRCSuccessTimes=" + RRCSuccessTimes +
                ", RRCTotalTimes=" + RRCTotalTimes +
                ", RRCSuccessRate=" + RRCSuccessRate +
                ", ERABSuccessTimes=" + ERABSuccessTimes +
                ", ERABTotalTimes=" + ERABTotalTimes +
                ", ERABSuccessRate=" + ERABSuccessRate +
                ", ERABAbnormalTimesEnode=" + ERABAbnormalTimesEnode +
                ", ERABAbnormalTimesCommunity=" + ERABAbnormalTimesCommunity +
                ", ERABAbnormalRate=" + ERABAbnormalRate +
                ", unlineSuccessRate=" + unlineSuccessRate +
                ", UEReleaseTimesEnode=" + UEReleaseTimesEnode +
                ", UEAbnormalReleaseTimes=" + UEAbnormalReleaseTimes +
                ", UESuccessTimes=" + UESuccessTimes +
                ", unlineFailedRate=" + unlineFailedRate +
                ", diffFrequencySuccessTimesIn=" + diffFrequencySuccessTimesIn +
                ", diffFrequencyTotalTimesIn=" + diffFrequencyTotalTimesIn +
                ", simuFrequencySuccessTimesIn=" + simuFrequencySuccessTimesIn +
                ", simuFrequencyTotalTimesIn=" + simuFrequencyTotalTimesIn +
                ", diffFrequencySuccessTimesAmong=" + diffFrequencySuccessTimesAmong +
                ", diffFrequencyTotalTimesAmong=" + diffFrequencyTotalTimesAmong +
                ", simuFrequencySuccessTimesAmong=" + simuFrequencySuccessTimesAmong +
                ", simuFrequencyTotalTimesAmong=" + simuFrequencyTotalTimesAmong +
                ", eNBSwitchSuccessRateIn=" + eNBSwitchSuccessRateIn +
                ", eNBSwitchSuccessRateAmong=" + eNBSwitchSuccessRateAmong +
                ", simuFrequencySwitchSuccessRate=" + simuFrequencySwitchSuccessRate +
                ", diffFrequencySwitchSuccessRate=" + diffFrequencySwitchSuccessRate +
                ", switchSuccessRate=" + switchSuccessRate +
                ", PDCPUpThroughput=" + PDCPUpThroughput +
                ", PDCPDownThroughput=" + PDCPDownThroughput +
                ", RRCRelinkTimes=" + RRCRelinkTimes +
                ", RRCRelinkRate=" + RRCRelinkRate +
                ", simuFrequencySwitchTimesAmong=" + simuFrequencySwitchTimesAmong +
                ", diffFrequencySwitchTimesAmong=" + diffFrequencySwitchTimesAmong +
                ", simuFrequencySwitchTimesIn=" + simuFrequencySwitchTimesIn +
                ", diffFrequencySwitchTimesIn=" + diffFrequencySwitchTimesIn +
                ", eNBSwitchSuccessTimes=" + eNBSwitchSuccessTimes +
                ", eNBSwitchTotalTimes=" + eNBSwitchTotalTimes +
                '}';
    }
}
