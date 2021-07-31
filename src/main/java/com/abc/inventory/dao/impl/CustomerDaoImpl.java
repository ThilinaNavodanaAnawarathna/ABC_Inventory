package com.abc.inventory.dao.impl;

import com.abc.inventory.dao.CustomerDao;
import com.abc.inventory.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Customer customer) throws Exception {
        String sql = "INSERT INTO CUSTOMER (ID,NAME,TELEPHONE,EMAIL,ADDRESS) VALUES (:id,:name,:telephone,:email,:address)";


        NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource mapSqlParameterSource=new MapSqlParameterSource();

        mapSqlParameterSource.addValue("id", customer.getId());
        mapSqlParameterSource.addValue("name", customer.getName());
        mapSqlParameterSource.addValue("telephone", customer.getTelephone());
        mapSqlParameterSource.addValue("email", customer.getEmail());
        mapSqlParameterSource.addValue("address", customer.getAddress());

        return namedParameterJdbcTemplate.update(sql, mapSqlParameterSource);
    }
}
