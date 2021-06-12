package myj2ee.bean;

import java.util.List;

public class PRB {
    private String startTime;
    private String baseStationName;
    private String community;
    private String communityName;
    private List<Integer> prbDatas;

    public PRB() {
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

    public List<Integer> getPrbDatas() {
        return prbDatas;
    }

    public void setPrbDatas(List<Integer> prbDatas) {
        this.prbDatas = prbDatas;
    }

    @Override
    public String toString() {
        return "PRB{" +
                "startTime='" + startTime + '\'' +
                ", baseStationName='" + baseStationName + '\'' +
                ", community='" + community + '\'' +
                ", communityName='" + communityName + '\'' +
                ", prbDatas=" + prbDatas +
                '}';
    }
}
