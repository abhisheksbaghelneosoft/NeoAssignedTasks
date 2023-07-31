package com.dbadmin.queryservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ColumnDetailsDto {

    @JsonProperty("table_name")
    private String tableName;

    @JsonProperty("column_name")
    private String columnName;

    @JsonProperty("column_type")
    private String columnType;

    private String value;

    private String condition;
}
