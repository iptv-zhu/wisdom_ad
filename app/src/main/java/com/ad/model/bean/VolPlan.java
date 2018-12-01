package com.ad.model.bean;

import java.io.Serializable;

public class VolPlan implements Serializable {
    private long startTime;

    private int id;

    private int did;

    private int vol;

    private long createDate;

    private long endTime;

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getDid() {
        return this.did;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public int getVol() {
        return this.vol;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getCreateDate() {
        return this.createDate;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

}
