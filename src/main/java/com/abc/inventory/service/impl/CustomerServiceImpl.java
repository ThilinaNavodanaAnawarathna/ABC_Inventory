package com.abc.inventory.service.impl;

import com.abc.inventory.dao.CustomerDao;
import com.abc.inventory.dto.CustomerDto;
import com.abc.inventory.model.Customer;
import com.abc.inventory.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CustomerDao customerDao;
    @Override

    public boolean save(CustomerDto customerDto) throws Exception {
        int save = customerDao.save(getCustomer(customerDto));
        if(save==1){
            return true;
        }else {
            return false;
        }

    }

    private Customer getCustomer(CustomerDto customerDto){
        return mapper.map(customerDto, Customer.class);
    }
    private CustomerDto getCustomerDto(Customer customer){
        return mapper.map(customer,CustomerDto.class);
    }
}
