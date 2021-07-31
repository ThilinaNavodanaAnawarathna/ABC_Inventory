package com.abc.inventory.dao;

import com.abc.inventory.model.Product;

public interface ProductDao {
    public int save(Product product)throws Exception;
}
