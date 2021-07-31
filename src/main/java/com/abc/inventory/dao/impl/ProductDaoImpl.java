package com.abc.inventory.dao.impl;

import com.abc.inventory.dao.ProductDao;
import com.abc.inventory.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Product product) throws Exception {
        String sql = "INSERT INTO PRODUCT (ID,NAME,PRICE,EXPIRED_DATE,TAX_RATE,DISCOUNT_RATE) VALUES (:id,:name,:price,:expiredDate,:taxRate,:discountRate)";


        NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource mapSqlParameterSource=new MapSqlParameterSource();

        mapSqlParameterSource.addValue("id", product.getId());
        mapSqlParameterSource.addValue("name", product.getName());
        mapSqlParameterSource.addValue("price", product.getPrice());
        mapSqlParameterSource.addValue("expiredDate", product.getExpirdDate());
        mapSqlParameterSource.addValue("taxRate", product.getTaxRate());
        mapSqlParameterSource.addValue("discountRate", product.getDiscountRate());

        return namedParameterJdbcTemplate.update(sql, mapSqlParameterSource);
    }
}
