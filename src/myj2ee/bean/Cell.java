package myj2ee.bean;


// tbCell
public class Cell {
    public Cell(String CITY, String SECTOR_ID, String SECTOR_NAME, Integer ENODEBID, String ENODEB_NAME, Integer EARFCN, Integer PCI, Integer PSS, Integer SSS, Integer TAC, String VENDOR, Float LONGITUDE, Float LATITUDE, String STYLE, Float AZIMUTH, Float HEIGHT, Float ELECTTILT, Float MECHTILT, Float TOTLETILT) {
        this.CITY = CITY;
        this.SECTOR_ID = SECTOR_ID;
        this.SECTOR_NAME = SECTOR_NAME;
        this.ENODEBID = ENODEBID;
        this.ENODEB_NAME = ENODEB_NAME;
        this.EARFCN = EARFCN;
        this.PCI = PCI;
        this.PSS = PSS;
        this.SSS = SSS;
        this.TAC = TAC;
        this.VENDOR = VENDOR;
        this.LONGITUDE = LONGITUDE;
        this.LATITUDE = LATITUDE;
        this.STYLE = STYLE;
        this.AZIMUTH = AZIMUTH;
        this.HEIGHT = HEIGHT;
        this.ELECTTILT = ELECTTILT;
        this.MECHTILT = MECHTILT;
        this.TOTLETILT = TOTLETILT;
    }

    private String CITY;
    private String SECTOR_ID;
    private String SECTOR_NAME;
    private Integer ENODEBID;
    private String ENODEB_NAME;
    private Integer EARFCN;
    private Integer PCI;
    private Integer PSS;
    private Integer SSS;
    private Integer TAC;
    private String VENDOR;
    private Float LONGITUDE;
    private Float LATITUDE;
    private String STYLE;
    private Float AZIMUTH;
    private Float HEIGHT;
    private Float ELECTTILT;
    private Float MECHTILT;
    private Float TOTLETILT;

    @Override
    public String toString() {
        return "Cell{" +
                "CITY='" + CITY + '\'' +
                ", SECTOR_ID='" + SECTOR_ID + '\'' +
                ", SECTOR_NAME='" + SECTOR_NAME + '\'' +
                ", ENODEBID=" + ENODEBID +
                ", ENODEB_NAME='" + ENODEB_NAME + '\'' +
                ", EARFCN=" + EARFCN +
                ", PCI=" + PCI +
                ", PSS=" + PSS +
                ", SSS=" + SSS +
                ", TAC=" + TAC +
                ", VENDOR='" + VENDOR + '\'' +
                ", LONGITUDE=" + LONGITUDE +
                ", LATITUDE=" + LATITUDE +
                ", STYLE='" + STYLE + '\'' +
                ", AZIMUTH=" + AZIMUTH +
                ", HEIGHT=" + HEIGHT +
                ", ELECTTILT=" + ELECTTILT +
                ", MECHTILT=" + MECHTILT +
                ", TOTLETILT=" + TOTLETILT +
                '}';
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSECTOR_ID() {
        return SECTOR_ID;
    }

    public void setSECTOR_ID(String SECTOR_ID) {
        this.SECTOR_ID = SECTOR_ID;
    }

    public String getSECTOR_NAME() {
        return SECTOR_NAME;
    }

    public void setSECTOR_NAME(String SECTOR_NAME) {
        this.SECTOR_NAME = SECTOR_NAME;
    }

    public Integer getENODEBID() {
        return ENODEBID;
    }

    public void setENODEBID(Integer ENODEBID) {
        this.ENODEBID = ENODEBID;
    }

    public String getENODEB_NAME() {
        return ENODEB_NAME;
    }

    public void setENODEB_NAME(String ENODEB_NAME) {
        this.ENODEB_NAME = ENODEB_NAME;
    }

    public Integer getEARFCN() {
        return EARFCN;
    }

    public void setEARFCN(Integer EARFCN) {
        this.EARFCN = EARFCN;
    }

    public Integer getPCI() {
        return PCI;
    }

    public void setPCI(Integer PCI) {
        this.PCI = PCI;
    }

    public Integer getPSS() {
        return PSS;
    }

    public void setPSS(Integer PSS) {
        this.PSS = PSS;
    }

    public Integer getSSS() {
        return SSS;
    }

    public void setSSS(Integer SSS) {
        this.SSS = SSS;
    }

    public Integer getTAC() {
        return TAC;
    }

    public void setTAC(Integer TAC) {
        this.TAC = TAC;
    }

    public String getVENDOR() {
        return VENDOR;
    }

    public void setVENDOR(String VENDOR) {
        this.VENDOR = VENDOR;
    }

    public Float getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(Float LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public Float getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(Float LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public String getSTYLE() {
        return STYLE;
    }

    public void setSTYLE(String STYLE) {
        this.STYLE = STYLE;
    }

    public Float getAZIMUTH() {
        return AZIMUTH;
    }

    public void setAZIMUTH(Float AZIMUTH) {
        this.AZIMUTH = AZIMUTH;
    }

    public Float getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(Float HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public Float getELECTTILT() {
        return ELECTTILT;
    }

    public void setELECTTILT(Float ELECTTILT) {
        this.ELECTTILT = ELECTTILT;
    }

    public Float getMECHTILT() {
        return MECHTILT;
    }

    public void setMECHTILT(Float MECHTILT) {
        this.MECHTILT = MECHTILT;
    }

    public Float getTOTLETILT() {
        return TOTLETILT;
    }

    public void setTOTLETILT(Float TOTLETILT) {
        this.TOTLETILT = TOTLETILT;
    }
}
