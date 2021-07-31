package com.abc.inventory.controller;

import com.abc.inventory.dto.ProductDto;
import com.abc.inventory.service.ProductService;
import com.abc.inventory.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;


@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/view_add_product")
    public ModelAndView viewAddProduct() throws Exception {
        ModelAndView modelAndView = new ModelAndView("product/view_add_product");
        return modelAndView;

    }

    @PostMapping(value = "/add_product")
    @ResponseBody
    public String save(@RequestParam String name, @RequestParam double price, @RequestParam String expirdDate)
            throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setId(UUID.randomUUID().toString());
        productDto.setName(name);
        productDto.setPrice(price);
        productDto.setExpirdDate(Utility.convertDateFormat(expirdDate));


        if (productService.save(productDto)) {
            return "200";
        } else {
            return "500";
        }


    }
}
