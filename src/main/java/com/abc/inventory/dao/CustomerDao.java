package com.abc.inventory.dao;

import com.abc.inventory.model.Customer;

public interface CustomerDao {
    public int save(Customer customer)throws Exception;
}
