package com.zensar.dao;

import com.zensar.model.source.SourceProduct;
import com.zensar.model.source.SourceProductWrapper;
import com.zensar.util.ProductConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class ProductDao {

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Gets all the products in category 600001506
     * @return list of all products in category 600001506
     */
    public List<SourceProduct> getProductsFromCategory600001506() {
        ResponseEntity<SourceProductWrapper> responseEntity = restTemplate.getForEntity(ProductConstants.CATEGORY_600001506_URL, SourceProductWrapper.class);
        SourceProductWrapper sourceProductWrapper = responseEntity.getBody();
        return sourceProductWrapper.getProducts();
    }

}
