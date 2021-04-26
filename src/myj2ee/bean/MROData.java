package myj2ee.bean;


// tbMROData
public class MROData {
    public MROData(String TimeStamp, String ServingSector, String interferingSector, Float LteScRSRP, Float LteNcRSRP, Integer LteNcEarfcn, Short LteNcPci){
        this.TimeStamp = TimeStamp;
        this.ServingSector = ServingSector;
        this.interferingSector = interferingSector;
        this.LteScRSRP = LteScRSRP;
        this.LteNcRSRP = LteNcRSRP;
        this.LteNcEarfcn = LteNcEarfcn;
        this.LteNcPci = LteNcPci;
    }
    private String TimeStamp;
    private String ServingSector;
    private String interferingSector;
    private Float LteScRSRP;
    private Float LteNcRSRP;
    private Integer LteNcEarfcn;
    private Short LteNcPci;

    @Override
    public String toString(){
        return "MROData{"+
                "TimeStamp: " + TimeStamp +
                ", ServingSector: "+ ServingSector +
                ", interferingSector: " + interferingSector +
                ", LteScRSRP: "+ LteScRSRP +
                ", LteNcRSRP: " + LteNcRSRP +
                ", LteNcEarfcn: "+ LteNcEarfcn +
                ", LteNcPci:"+ LteNcPci +
                "}";
    }
    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.TimeStamp = timeStamp;
    }

    public String getServingSector() {
        return ServingSector;
    }

    public void setServingSector(String servingSector) {
        this.ServingSector = servingSector;
    }

    public String getInterferingSector() {
        return interferingSector;
    }

    public void setInterferingSector(String interferingSector) {
        this.interferingSector = interferingSector;
    }

    public Float getLteScRSRP() {
        return LteScRSRP;
    }

    public void setLteScRSRP(Float lteScRSRP) {
        this.LteScRSRP = lteScRSRP;
    }

    public Float getLteNcRSRP() {
        return LteNcRSRP;
    }

    public void setLteNcRSRP(Float lteNcRSRP) {
        this.LteNcRSRP = lteNcRSRP;
    }

    public Integer getLteNcEarfcn() {
        return LteNcEarfcn;
    }

    public void setLteNcEarfcn(Integer lteNcEarfcn) {
        this.LteNcEarfcn = lteNcEarfcn;
    }

    public Short getLteNcPci() {
        return LteNcPci;
    }

    public void setLteNcPci(Short lteNcPci) {
        this.LteNcPci = lteNcPci;
    }
}
