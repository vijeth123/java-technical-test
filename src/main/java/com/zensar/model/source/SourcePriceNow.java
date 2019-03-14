package com.zensar.model.source;

import java.io.Serializable;

public class SourcePriceNow implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double to;
    private Double from;

    public SourcePriceNow(){
    }

    public Double getTo() {
        return to;
    }

    public void setTo(Double to) {
        this.to = to;
    }

    public Double getFrom() {
        return from;
    }

    public void setFrom(Double from) {
        this.from = from;
    }
}
