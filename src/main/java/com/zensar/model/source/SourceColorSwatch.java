package com.zensar.model.source;

import java.io.Serializable;

public class SourceColorSwatch implements Serializable {

    private static final long serialVersionUID = 1L;

    private String color;
    private String basicColor;
    private String colorSwatchUrl;
    private String imageUrl;
    private boolean isAvailable;
    private String skuId;

    public SourceColorSwatch(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBasicColor() {
        return basicColor;
    }

    public void setBasicColor(String basicColor) {
        this.basicColor = basicColor;
    }

    public String getColorSwatchUrl() {
        return colorSwatchUrl;
    }

    public void setColorSwatchUrl(String colorSwatchUrl) {
        this.colorSwatchUrl = colorSwatchUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }
}
