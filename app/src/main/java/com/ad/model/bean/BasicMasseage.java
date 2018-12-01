package com.ad.model.bean;

import java.io.Serializable;

public class BasicMasseage implements Serializable {
    private int stbGroupId;

    private int switchStatus;

    private int countSize;

    private String mac;

    private String resolution;

    private int onlineStatus;

    private String ipaddress;

    private String version;

    private int skinId;

    private int id;

    private int siteId;

    private String ram;

    private String name;

    private int voiceSet;

    public void setStbGroupId(int stbGroupId) {
        this.stbGroupId = stbGroupId;
    }

    public int getStbGroupId() {
        return this.stbGroupId;
    }

    public void setSwitchStatus(int switchStatus) {
        this.switchStatus = switchStatus;
    }

    public int getSwitchStatus() {
        return this.switchStatus;
    }

    public void setCountSize(int countSize) {
        this.countSize = countSize;
    }

    public int getCountSize() {
        return this.countSize;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getMac() {
        return this.mac;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public int getOnlineStatus() {
        return this.onlineStatus;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getIpaddress() {
        return this.ipaddress;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

    public void setSkinId(int skinId) {
        this.skinId = skinId;
    }

    public int getSkinId() {
        return this.skinId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getSiteId() {
        return this.siteId;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRam() {
        return this.ram;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setVoiceSet(int voiceSet) {
        this.voiceSet = voiceSet;
    }

    public int getVoiceSet() {
        return this.voiceSet;
    }
}
