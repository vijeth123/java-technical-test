package com.zensar.model.source;

import java.io.Serializable;

public class SourceProduct implements Serializable{

    private static final long serialVersionUID = 1L;

    private String productId;
    private String title;
    private SourcePrice price;
    private SourceColorSwatch[] colorSwatches;

    public SourceProduct(){}

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

    public SourcePrice getPrice() {
        return price;
    }

    public void setPrice(SourcePrice price) {
        this.price = price;
    }

    public SourceColorSwatch[] getColorSwatches() {
        return colorSwatches;
    }

    public void setColorSwatches(SourceColorSwatch[] colorSwatches) {
        this.colorSwatches = colorSwatches;
    }
}
