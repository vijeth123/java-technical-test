package com.zensar.service;

import com.zensar.model.source.SourceColorSwatch;
import com.zensar.model.source.SourcePrice;
import com.zensar.model.source.SourceProduct;
import com.zensar.model.target.TargetColorSwatch;
import com.zensar.model.target.TargetProduct;
import com.zensar.util.BasicColorToRGBMapper;
import com.zensar.util.CurrencyToSymbolMapper;
import com.zensar.util.PriceFormatter;
import org.springframework.stereotype.Service;

/**
 * This is a helper class for 'ProductService' which segregates different business logics
 */
@Service
public class ProductHelperService {

    /**
     * The purpose of this method is to properly map color-swatch from the source to the target
     * @param targetProduct
     * @param sourceProduct
     */
    public void populateColorSwatchesOfTarget(TargetProduct targetProduct, SourceProduct sourceProduct) {
        SourceColorSwatch[] sourceColorSwatchArray = sourceProduct.getColorSwatches();
        if(sourceColorSwatchArray.length != 0){
            TargetColorSwatch[] targetColorSwatchArray = new TargetColorSwatch[sourceColorSwatchArray.length];

            for(int i=0;i < sourceColorSwatchArray.length;i++){
                SourceColorSwatch sourceColorSwatch = sourceColorSwatchArray[i];
                TargetColorSwatch targetColorSwatch = new TargetColorSwatch();
                targetColorSwatch.setColor(sourceColorSwatch.getColor());
                targetColorSwatch.setRgbColor(BasicColorToRGBMapper.getRGBColor(sourceColorSwatch.getBasicColor().trim()));
                targetColorSwatch.setSkuid(sourceColorSwatch.getSkuId());
                targetColorSwatchArray[i] = targetColorSwatch;
            }
            targetProduct.setColorSwatches(targetColorSwatchArray);
        }
    }


    /**
     * The purpose of this method is to format 'now' field from the source and to populate 'NowPrice' of the target
     * @param targetProduct
     * @param sourceProduct
     */
    public void populateNowPriceOfTarget(TargetProduct targetProduct, SourceProduct sourceProduct) {
        SourcePrice sourcePrice = sourceProduct.getPrice();
        String currencySymbol = CurrencyToSymbolMapper.getCurrencySymbol(sourcePrice.getCurrency());
        targetProduct.setNowPrice(PriceFormatter.format(currencySymbol, sourcePrice.getNow()));
    }


    /**
     * Based on 'labelType' value (optional query param), the 'priceLabel' field is calculated accordingly here.
     * @param targetProduct
     * @param sourceProduct
     * @param labelType
     */
    public void populatePriceLabelOfTarget(TargetProduct targetProduct, SourceProduct sourceProduct, String labelType) {
        SourcePrice sourcePrice = sourceProduct.getPrice();
        String currencySymbol = CurrencyToSymbolMapper.getCurrencySymbol(sourcePrice.getCurrency());

        StringBuilder priceLabelBuilder = new StringBuilder();
        String priceLabel = "";

        switch (labelType){
            default:
            case "ShowWasNow": priceLabelBuilder.setLength(0);
                priceLabel = priceLabelBuilder.append("Was ")
                        .append(PriceFormatter.format(currencySymbol, sourcePrice.getWas()))
                        .append(", now ")
                        .append(PriceFormatter.format(currencySymbol, sourcePrice.getNow())).toString();
                break;

            case "ShowWasThenNow": priceLabelBuilder.setLength(0);
                String thenPrice = (!sourcePrice.getThen2().isEmpty()) ? sourcePrice.getThen2() : sourcePrice.getThen1();

                StringBuilder thenPriceAppender = new StringBuilder();
                if(!thenPrice.isEmpty()){
                    thenPriceAppender.append(", then ").append(PriceFormatter.format(currencySymbol, thenPrice));
                }

                priceLabel = priceLabelBuilder.append("Was ")
                        .append(PriceFormatter.format(currencySymbol, sourcePrice.getWas()))
                        .append(thenPriceAppender)
                        .append(", now ")
                        .append(PriceFormatter.format(currencySymbol, sourcePrice.getNow())).toString();
                break;

            case "ShowPercDscount": priceLabelBuilder.setLength(0);
                String was = sourcePrice.getWas();
                String now = sourcePrice.getNow();

                Double wasDouble = (!was.isEmpty()) ? Double.parseDouble(was) : 0.0;
                Double nowDouble = (!now.isEmpty()) ? Double.parseDouble(now) : 0.0;
                Double discount = wasDouble - nowDouble;

                priceLabel = priceLabelBuilder.append(discount)
                        .append("% off")
                        .append(", now ")
                        .append(PriceFormatter.format(currencySymbol, sourcePrice.getNow())).toString();
                break;

        }
        targetProduct.setPriceLabel(priceLabel);
    }
}
