package myj2ee.bean;


// tbc2i
public class C2i {

    public C2i(){

    }

    public C2i(String CITY, String SCELL, String NCELL, Integer PrC2I9, Float C2I_Mean, Float Std, Integer SampleCount, Integer WeightedC2I){
        this.CITY = CITY;
        this.SCELL = SCELL;
        this.NCELL = NCELL;
        this.PrC2I9 = PrC2I9;
        this.C2I_Mean = C2I_Mean;
        this.Std = Std;
        this.SampleCount = SampleCount;
        this.WeightedC2I = WeightedC2I;
    }
    private String CITY;
    private String SCELL;
    private String NCELL;
    private Integer PrC2I9;
    private Float C2I_Mean;
    private Float Std;
    private Integer SampleCount;
    private Integer WeightedC2I;

    @Override
    public String toString() {
        return "C2i{" +
                "CITY='" + CITY + '\'' +
                ", SCELL='" + SCELL + '\'' +
                ", NCELL='" + NCELL + '\'' +
                ", PrC2I9=" + PrC2I9 +
                ", C2I_Mean=" + C2I_Mean +
                ", Std=" + Std +
                ", SampleCount=" + SampleCount +
                ", WeightedC2I=" + WeightedC2I +
                '}';
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSCELL() {
        return SCELL;
    }

    public void setSCELL(String SCELL) {
        this.SCELL = SCELL;
    }

    public String getNCELL() {
        return NCELL;
    }

    public void setNCELL(String NCELL) {
        this.NCELL = NCELL;
    }

    public Integer getPrC2I9() {
        return PrC2I9;
    }

    public void setPrC2I9(Integer prC2I9) {
        this.PrC2I9 = prC2I9;
    }

    public Float getC2I_Mean() {
        return C2I_Mean;
    }

    public void setC2I_Mean(Float c2I_Mean) {
        this.C2I_Mean = c2I_Mean;
    }

    public Float getStd() {
        return Std;
    }

    public void setStd(Float std) {
        this.Std = std;
    }

    public Integer getSampleCount() {
        return SampleCount;
    }

    public void setSampleCount(Integer sampleCount) {
        this.SampleCount = sampleCount;
    }

    public Integer getWeightedC2I() {
        return WeightedC2I;
    }

    public void setWeightedC2I(Integer weightedC2I) {
        this.WeightedC2I = weightedC2I;
    }
}
