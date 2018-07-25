package com.shiro.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateUtils {
    private static JdbcTemplate jdbcTemplate;

    public static JdbcTemplate jdbcTemplate(){
        if(jdbcTemplate==null){
            jdbcTemplate=createJdbcTemplate();
        }
        return jdbcTemplate;
    }

    public static JdbcTemplate createJdbcTemplate(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/shiro");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return new JdbcTemplate(dataSource);
    }
}
