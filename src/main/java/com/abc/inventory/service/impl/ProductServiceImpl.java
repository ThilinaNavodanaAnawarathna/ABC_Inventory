package com.abc.inventory.service.impl;

import com.abc.inventory.dao.ProductDao;
import com.abc.inventory.dto.ProductDto;
import com.abc.inventory.model.Product;
import com.abc.inventory.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProductDao productDao;

    @Override
    public boolean save(ProductDto productDto) throws Exception {
        int save = productDao.save(getProduct(productDto));
        if(save==1){
            return true;
        }else {
            return false;
        }

    }
    private Product getProduct(ProductDto productDto){
        return mapper.map(productDto,Product.class);
    }
    private ProductDto getProductDto(Product product){
        return mapper.map(product,ProductDto.class);
    }
}
