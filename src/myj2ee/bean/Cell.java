package myj2ee.bean;


// tbCell
public class Cell {
    public Cell(){

    }

    public Cell(String city, String sectorId, String sectorName, Integer enodebId, String enodebName, Integer earfcn, Integer pci, Integer pss, Integer sss, Integer tac, String vendor, Float longitude, Float latitude, String style, Float azimuth, Float height, Float electtilt, Float mechtilt, Float totletilt) {
        this.city = city;
        this.sectorId = sectorId;
        this.sectorName = sectorName;
        this.enodebId = enodebId;
        this.enodebName = enodebName;
        this.earfcn = earfcn;
        this.pci = pci;
        this.pss = pss;
        this.sss = sss;
        this.tac = tac;
        this.vendor = vendor;
        this.longitude = longitude;
        this.latitude = latitude;
        this.style = style;
        this.azimuth = azimuth;
        this.height = height;
        this.electtilt = electtilt;
        this.mechtilt = mechtilt;
        this.totletilt = totletilt;
    }

    private String city;
    private String sectorId;
    private String sectorName;
    private Integer enodebId;
    private String enodebName;
    private Integer earfcn;
    private Integer pci;
    private Integer pss;
    private Integer sss;
    private Integer tac;
    private String vendor;
    private Float longitude;
    private Float latitude;
    private String style;
    private Float azimuth;
    private Float height;
    private Float electtilt;
    private Float mechtilt;
    private Float totletilt;


    @Override
    public String toString() {
        return "Cell{" +
                "CITY='" + city + '\'' +
                ", SECTOR_ID='" + sectorId + '\'' +
                ", SECTOR_NAME='" + sectorName + '\'' +
                ", ENODEBID=" + enodebId +
                ", ENODEB_NAME='" + enodebName + '\'' +
                ", EARFCN=" + earfcn +
                ", PCI=" + pci +
                ", PSS=" + pss +
                ", SSS=" + sss +
                ", TAC=" + tac +
                ", VENDOR='" + vendor + '\'' +
                ", LONGITUDE=" + longitude +
                ", LATITUDE=" + latitude +
                ", STYLE='" + style + '\'' +
                ", AZIMUTH=" + azimuth +
                ", HEIGHT=" + height +
                ", ELECTTILT=" + electtilt +
                ", MECHTILT=" + mechtilt +
                ", TOTLETILT=" + totletilt +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSectorId() {
        return sectorId;
    }

    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public Integer getEnodebId() {
        return enodebId;
    }

    public void setEnodebId(Integer enodebId) {
        this.enodebId = enodebId;
    }

    public String getEnodebName() {
        return enodebName;
    }

    public void setEnodebName(String enodebName) {
        this.enodebName = enodebName;
    }

    public Integer getEarfcn() {
        return earfcn;
    }

    public void setEarfcn(Integer earfcn) {
        this.earfcn = earfcn;
    }

    public Integer getPci() {
        return pci;
    }

    public void setPci(Integer pci) {
        this.pci = pci;
    }

    public Integer getPss() {
        return pss;
    }

    public void setPss(Integer pss) {
        this.pss = pss;
    }

    public Integer getSss() {
        return sss;
    }

    public void setSss(Integer sss) {
        this.sss = sss;
    }

    public Integer getTac() {
        return tac;
    }

    public void setTac(Integer tac) {
        this.tac = tac;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Float getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(Float azimuth) {
        this.azimuth = azimuth;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getElecttilt() {
        return electtilt;
    }

    public void setElecttilt(Float electtilt) {
        this.electtilt = electtilt;
    }

    public Float getMechtilt() {
        return mechtilt;
    }

    public void setMechtilt(Float mechtilt) {
        this.mechtilt = mechtilt;
    }

    public Float getTotletilt() {
        return totletilt;
    }

    public void setTotletilt(Float totletilt) {
        this.totletilt = totletilt;
    }
}
