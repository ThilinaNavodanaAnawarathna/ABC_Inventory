package com.abc.inventory.controller;

import com.abc.inventory.dto.CustomerDto;
import com.abc.inventory.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping(value = "/view_add_customer")
    public ModelAndView viewAddCustomer()throws Exception{
        ModelAndView modelAndView=new ModelAndView("customer/view_add_customer");
        return modelAndView;
    }

    @PostMapping(value = "/add_customer")
    @ResponseBody
    public String save(@RequestParam String name,@RequestParam String address,@RequestParam String email,
                       @RequestParam String telephone)throws Exception{
        CustomerDto customerDto=new CustomerDto();
        customerDto.setId(UUID.randomUUID().toString());
        customerDto.setName(name);
        customerDto.setAddress(address);
        customerDto.setEmail(email);
        customerDto.setTelephone(telephone);

        if(customerService.save(customerDto)){
            return "200";
        }else {
            return "500";
        }

    }
}
