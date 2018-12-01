package com.ad.model.bean;

import java.io.Serializable;

public class Register implements Serializable {
    private String mac;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getVoice() {
        return voice;
    }

    public void setVoice(Integer voice) {
        this.voice = voice;
    }

    public Integer getReboot() {
        return reboot;
    }

    public void setReboot(Integer reboot) {
        this.reboot = reboot;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    private String version;  //版本(非空)
    private Integer voice;   //音量(非空)
    private Integer reboot;  //重启
    private String resolution; //分辨率（非空）
    private String ram;      //内存信息（非空）
}
