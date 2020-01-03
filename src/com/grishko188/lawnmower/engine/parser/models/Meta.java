package com.grishko188.lawnmower.engine.parser.models;

import java.util.ArrayList;
import java.util.List;

public class Meta {

    private int lawnWidth;
    private int lawnHeight;
    private List<MowerMeta> mowerMetaData;

    public void setLawnWidth(int lawnWidth) {
        this.lawnWidth = lawnWidth;
    }

    public void setLawnHeight(int lawnHeight) {
        this.lawnHeight = lawnHeight;
    }

    public void setMowerMetaData(List<MowerMeta> mowerMetaData) {
        this.mowerMetaData = mowerMetaData;
    }

    public int getLawnWidth() {
        return lawnWidth;
    }

    public int getLawnHeight() {
        return lawnHeight;
    }

    public List<MowerMeta> getMowerMetaData() {
        return mowerMetaData;
    }
}
