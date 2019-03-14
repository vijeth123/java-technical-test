package com.zensar.model.target;

import java.io.Serializable;

public class TargetColorSwatch implements Serializable {

    private static final long serialVersionUID = 1L;

    private String color;
    private String rgbColor;
    private String skuid;

    public TargetColorSwatch(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRgbColor() {
        return rgbColor;
    }

    public void setRgbColor(String rgbColor) {
        this.rgbColor = rgbColor;
    }

    public String getSkuid() {
        return skuid;
    }

    public void setSkuid(String skuid) {
        this.skuid = skuid;
    }
}
