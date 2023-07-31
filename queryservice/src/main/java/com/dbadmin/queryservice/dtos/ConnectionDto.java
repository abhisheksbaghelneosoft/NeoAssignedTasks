package com.dbadmin.queryservice.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ConnectionDto {

    @JsonProperty("datasource_url")
    private String datasourceUrl;

    private String username;
    private String password;

    @JsonProperty("driver_class_name")
    private String driverClassName;

}
