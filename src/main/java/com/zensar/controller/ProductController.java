package com.zensar.controller;

import com.zensar.model.target.TargetProduct;
import com.zensar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/filtered")
    public List<TargetProduct> getProcessedProducts(@RequestParam(value = "labelType", defaultValue = "ShowWasNow") String labelType){
        System.out.println("LabelType is: "+labelType);
        return productService.getProducts(labelType);
    }
}
