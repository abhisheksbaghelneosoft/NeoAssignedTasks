package com.dbadmin.queryservice.configs;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    @Bean
    public DataSource getDataSource()
    {
        DataSourceBuilder<?> dsb= DataSourceBuilder.create();
        return dsb.driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/database1?allowPublicKeyRetrieval=true&useSSL=false")
                .username("root")
                .password("password")
                .build();
    }

    public DataSource getDataSource(String driverClass,String dataUrl,String unm,String pass)
    {
        DataSourceBuilder<?> dsb= DataSourceBuilder.create();
        return dsb.driverClassName(driverClass)
                .url(dataUrl)
                .username(unm)
                .password(pass)
                .build();
    }

}

