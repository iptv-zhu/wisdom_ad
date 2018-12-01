package com.ad.model.bean;

import java.io.Serializable;
import java.util.List;

class Pages implements Serializable {
    private int id;

    private List<Elements> elements;

    private int duration;

    private int tid;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setElements(List<Elements> elements) {
        this.elements = elements;
    }

    public List<Elements> getElements() {
        return this.elements;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getTid() {
        return this.tid;
    }

}
