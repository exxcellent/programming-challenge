package de.exxcellent.challenge.bo;

public class WeatherDataBO {
    private Integer day;
    private Integer maxTemperature;
    private Integer minTemperature;
    private Double avt;
    private Double avdp;
    private Integer oneHrP_tpCpn;
    private Integer pDir;
    private Double avSp;
    private Integer dir;
    private Integer mxS;
    private Double skyC;
    private Integer mxR;
    private Integer mn;
    private Double r_avSlp;

    public WeatherDataBO(String weatherDataStr) {
        String[] weatherData = weatherDataStr.split(",");
        this.day = Integer.parseInt(weatherData[0]);
        this.maxTemperature = Integer.parseInt(weatherData[1]);
        this.minTemperature = Integer.parseInt(weatherData[2]);
        this.avt = Double.parseDouble(weatherData[3]);
        this.avdp = Double.parseDouble(weatherData[4]);
        this.oneHrP_tpCpn = Integer.parseInt(weatherData[5]);
        this.pDir = Integer.parseInt(weatherData[6]);
        this.avSp = Double.parseDouble(weatherData[7]);
        this.dir = Integer.parseInt(weatherData[8]);
        this.mxS = Integer.parseInt(weatherData[9]);
        this.skyC = Double.parseDouble(weatherData[10]);
        this.mxR = Integer.parseInt(weatherData[11]);
        this.mn = Integer.parseInt(weatherData[12]);
        this.r_avSlp = Double.parseDouble(weatherData[13]);
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Integer maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Integer getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Integer minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getAvt() {
        return avt;
    }

    public void setAvt(Double avt) {
        this.avt = avt;
    }

    public Double getAvdp() {
        return avdp;
    }

    public void setAvdp(Double avdp) {
        this.avdp = avdp;
    }

    public Integer getOneHrP_tpCpn() {
        return oneHrP_tpCpn;
    }

    public void setOneHrP_tpCpn(Integer oneHrP_tpCpn) {
        this.oneHrP_tpCpn = oneHrP_tpCpn;
    }

    public Integer getpDir() {
        return pDir;
    }

    public void setpDir(Integer pDir) {
        this.pDir = pDir;
    }

    public Double getAvSp() {
        return avSp;
    }

    public void setAvSp(Double avSp) {
        this.avSp = avSp;
    }

    public Integer getDir() {
        return dir;
    }

    public void setDir(Integer dir) {
        this.dir = dir;
    }

    public Integer getMxS() {
        return mxS;
    }

    public void setMxS(Integer mxS) {
        this.mxS = mxS;
    }

    public Double getSkyC() {
        return skyC;
    }

    public void setSkyC(Double skyC) {
        this.skyC = skyC;
    }

    public Integer getMxR() {
        return mxR;
    }

    public void setMxR(Integer mxR) {
        this.mxR = mxR;
    }

    public Integer getMn() {
        return mn;
    }

    public void setMn(Integer mn) {
        this.mn = mn;
    }

    public Double getR_avSlp() {
        return r_avSlp;
    }

    public void setR_avSlp(Double r_avSlp) {
        this.r_avSlp = r_avSlp;
    }
}
