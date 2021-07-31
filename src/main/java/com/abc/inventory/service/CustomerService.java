package com.abc.inventory.service;

import com.abc.inventory.dto.CustomerDto;

public interface CustomerService {
    public boolean save(CustomerDto customerDto)throws Exception;
}
