package myj2ee.bean;


// tbc2i3
public class C2i3 {
    public C2i3(String acell, String bcell, String ccell){
        this.acell = acell;
        this.bcell = bcell;
        this.ccell = ccell;
    }
    private String acell;
    private String bcell;
    private String ccell;

    @Override
    public String toString(){
        return "C2i3{"+
                "acell: " + acell +
                ", bcell: "+ bcell +
                ", ccell:"+ ccell +
                "}";
    }

    public String getAcell() {
        return acell;
    }

    public void setAcell(String acell) {
        this.acell = acell;
    }

    public String getBcell() {
        return bcell;
    }

    public void setBcell(String bcell) {
        this.bcell = bcell;
    }

    public String getCcell() {
        return ccell;
    }

    public void setCcell(String ccell) {
        this.ccell = ccell;
    }
}
