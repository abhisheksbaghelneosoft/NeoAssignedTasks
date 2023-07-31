package com.dbadmin.queryservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class TableDetailsDto {

    @JsonProperty("table_name")
    private String tableName;

    @JsonProperty("column_list")
    private List<ColumnDetailsDto> columnList;

}
