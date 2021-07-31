package com.abc.inventory.service;

import com.abc.inventory.dto.CustomerDto;
import com.abc.inventory.dto.ProductDto;

public interface ProductService {
    public boolean save(ProductDto productDto)throws Exception;
}
