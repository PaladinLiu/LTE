package myj2ee.bean;


// tbc2inew
public class C2inew {
    public C2inew(String SCELL, String NCELL, Float C2I_Mean, Float C2I_std, Float PrbC2I9, Float PrbABS6) {
        this.SCELL = SCELL;
        this.NCELL = NCELL;
        this.C2I_Mean = C2I_Mean;
        this.C2I_std = C2I_std;
        this.PrbC2I9 = PrbC2I9;
        this.PrbABS6 = PrbABS6;
    }
    private String SCELL;
    private String NCELL;
    private Float C2I_Mean;
    private Float C2I_std;
    private Float PrbC2I9;
    private Float PrbABS6;

    @Override
    public String toString(){
        return "C2inew{"+
                "SCELL: "+ SCELL +
                ", NCELL: " + NCELL +
                ", C2I_Mean: " + C2I_Mean +
                ", C2I_std: " + C2I_std +
                ", PrbC2I9: "+ PrbC2I9 +
                ", PrbABS6:"+ PrbABS6 +
                "}";
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

    public Float getC2I_Mean() {
        return C2I_Mean;
    }

    public void setC2I_Mean(Float c2I_Mean) {
        this.C2I_Mean = c2I_Mean;
    }

    public Float getC2I_std() {
        return C2I_std;
    }

    public void setStd(Float C2I_std) {
        this.C2I_std = C2I_std;
    }

    public Float getPrbC2I9() {
        return PrbC2I9;
    }

    public void setPrbC2I9(Float prbC2I9) {
        this.PrbC2I9 = prbC2I9;
    }

    public Float getPrbABS6() {
        return PrbABS6;
    }

    public void setPrbABS6(Float prbABS6) {
        this.PrbABS6 = prbABS6;
    }
}
