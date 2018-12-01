package com.ad.model.bean;

import java.io.Serializable;
import java.util.List;

class Themes implements Serializable {
    private int canvasWidth;

    private int canvasHeight;

    private int id;

    private String title;

    private int type;

    private String description;

    private List<Pages> pages;

    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public int getCanvasWidth() {
        return this.canvasWidth;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPages(List<Pages> pages) {
        this.pages = pages;
    }

    public List<Pages> getPages() {
        return this.pages;
    }
}
