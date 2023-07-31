package com.dbadmin.queryservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
public class JoinsDto {

    @JsonProperty("table_name1")
    private String tableName1;

    @JsonProperty("column_name1")
    private String columnName1;

    @JsonProperty("column_type1")
    private String columnType1;

    @JsonProperty("table_name2")
    private String tableName2;

    @JsonProperty("column_name2")
    private String columnName2;

    @JsonProperty("column_type2")
    private String columnType2;

    private String condition;
}
