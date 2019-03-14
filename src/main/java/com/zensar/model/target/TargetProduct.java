package com.zensar.model.target;

import java.io.Serializable;

public class TargetProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productId;
    private String title;
    private TargetColorSwatch[] colorSwatches;
    private String nowPrice;
    private String priceLabel;

    public TargetProduct(){}

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TargetColorSwatch[] getColorSwatches() {
        return colorSwatches;
    }

    public void setColorSwatches(TargetColorSwatch[] colorSwatches) {
        this.colorSwatches = colorSwatches;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getPriceLabel() {
        return priceLabel;
    }

    public void setPriceLabel(String priceLabel) {
        this.priceLabel = priceLabel;
    }
}
