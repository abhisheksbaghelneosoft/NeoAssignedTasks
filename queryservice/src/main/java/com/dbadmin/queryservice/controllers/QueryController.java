package com.dbadmin.queryservice.controllers;

import com.dbadmin.queryservice.dtos.QueryDto;
import com.dbadmin.queryservice.services.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private JdbcService jdbcService;

    @PostMapping("/create")
    public List<Map<String ,Object>> sendQueryDto(@RequestBody QueryDto queryDto)
    {
        return jdbcService.makeQuery(queryDto);
    }

    @GetMapping("/get-all-tables")
    public List<Map<String,Object>> getTables()
    {
        return jdbcService.getTables();
    }


}
