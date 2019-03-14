package com.zensar.model.source;

import java.io.Serializable;
import java.util.List;

public class SourceProductWrapper implements Serializable {
    private static final long serialVersionUID = 1L;

    List<SourceProduct> products;

    public SourceProductWrapper(){}

    public List<SourceProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SourceProduct> products) {
        this.products = products;
    }
}
