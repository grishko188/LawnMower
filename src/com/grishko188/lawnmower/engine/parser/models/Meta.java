package com.grishko188.lawnmower.engine.parser.models;

import com.sun.istack.internal.NotNull;

import java.util.List;

public class Meta {
    private int lawnWidth;
    private int lawnHeight;
    @NotNull
    private List<MowerMeta> mowerMetaData;

    public void setLawnWidth(int lawnWidth) {
        this.lawnWidth = lawnWidth;
    }

    public void setLawnHeight(int lawnHeight) {
        this.lawnHeight = lawnHeight;
    }

    @NotNull
    public void setMowerMetaData(List<MowerMeta> mowerMetaData) {
        this.mowerMetaData = mowerMetaData;
    }

    public int getLawnWidth() {
        return lawnWidth;
    }

    public int getLawnHeight() {
        return lawnHeight;
    }

    @NotNull
    public List<MowerMeta> getMowerMetaData() {
        return mowerMetaData;
    }
}
