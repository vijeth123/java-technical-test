package com.zensar.service;

import com.zensar.dao.ProductDao;
import com.zensar.model.source.SourcePrice;
import com.zensar.model.source.SourceProduct;
import com.zensar.model.target.TargetProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

   @Autowired
   public ProductHelperService productHelperService;

   @Autowired
   public ProductDao productDao;

   public List<TargetProduct> getProducts(String labelType) {

        List<TargetProduct> targetProducts = new ArrayList<>();
        List<SourceProduct> sourceProducts = productDao.getProductsFromCategory600001506();

        sourceProducts.stream().filter(sourceProduct -> {
            SourcePrice sourcePrice = sourceProduct.getPrice();
            String was = sourcePrice.getWas();
            String now = sourcePrice.getNow();
            Double wasDouble = (!was.isEmpty()) ? Double.parseDouble(was) : 0.0;
            Double nowDouble = (!now.isEmpty()) ? Double.parseDouble(now) : 0.0;
            return wasDouble > nowDouble;
        }).sorted(Comparator.comparing(sourceProduct -> {
            SourcePrice sourcePrice = sourceProduct.getPrice();
            String was = sourcePrice.getWas();
            String now = sourcePrice.getNow();
            Double wasDouble = (!was.isEmpty()) ? Double.parseDouble(was) : 0.0;
            Double nowDouble = (!now.isEmpty()) ? Double.parseDouble(now) : 0.0;
            return nowDouble - wasDouble;
        })).forEach(sourceProduct -> {
            TargetProduct targetProduct = new TargetProduct();
            targetProduct.setProductId(sourceProduct.getProductId());
            targetProduct.setTitle(sourceProduct.getTitle());
            productHelperService.populateColorSwatchesOfTarget(targetProduct, sourceProduct);
            productHelperService.populateNowPriceOfTarget(targetProduct, sourceProduct);
            productHelperService.populatePriceLabelOfTarget(targetProduct, sourceProduct, labelType);
            targetProducts.add(targetProduct);
        });
        return targetProducts;
    }
}
