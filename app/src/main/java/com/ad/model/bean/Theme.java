package com.ad.model.bean;

import java.io.Serializable;
import java.util.List;

public class Theme implements Serializable {
    private int id;

    private boolean interCut;

    private List<Themes> themes;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setInterCut(boolean interCut) {
        this.interCut = interCut;
    }

    public boolean getInterCut() {
        return this.interCut;
    }

    public void setThemes(List<Themes> themes) {
        this.themes = themes;
    }

    public List<Themes> getThemes() {
        return this.themes;
    }
}
