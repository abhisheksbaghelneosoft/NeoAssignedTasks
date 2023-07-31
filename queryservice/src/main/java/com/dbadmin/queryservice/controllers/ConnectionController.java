package com.dbadmin.queryservice.controllers;

import com.dbadmin.queryservice.dtos.ConnectionDto;
import com.dbadmin.queryservice.services.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connect")
public class ConnectionController {


    @Autowired
    private JdbcService jdbcService;

    @PostMapping("/db")
    public String connectToDb(@RequestBody ConnectionDto connectionDto)
    {
        return jdbcService.getDataSourceConnection(connectionDto);
    }

}
