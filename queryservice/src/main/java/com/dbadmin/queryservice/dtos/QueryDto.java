package com.dbadmin.queryservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class QueryDto {

    @JsonProperty("select_list")
    private List<TableDetailsDto> selectList;

    @JsonProperty("where_list")
    private List<TableDetailsDto> whereList;

    @JsonProperty("join_list")
    private List<JoinsDto> joinList;
}
