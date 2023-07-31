package com.dbadmin.queryservice.services;

import com.dbadmin.queryservice.configs.DataSourceConfig;
import com.dbadmin.queryservice.constants.SqlKeywords;
import com.dbadmin.queryservice.constants.Symbols;
import com.dbadmin.queryservice.dtos.ColumnDetailsDto;
import com.dbadmin.queryservice.dtos.ConnectionDto;
import com.dbadmin.queryservice.dtos.QueryDto;
import com.dbadmin.queryservice.dtos.TableDetailsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class JdbcService {

    @Autowired
    private DataSourceConfig dataSourceConfig;

    private DataSource dataSource;
    private Connection conn;

    private Logger log = LoggerFactory.getLogger(JdbcService.class);

    public String getDataSourceConnection(ConnectionDto connectionBean)
    {
        dataSource= dataSourceConfig.getDataSource(connectionBean.getDriverClassName(),
                connectionBean.getDatasourceUrl(),
                connectionBean.getUsername(),
                connectionBean.getPassword());
        try{
            conn=dataSource.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        log.info("##"+"Connection created with"+" : "+connectionBean.getDatasourceUrl()+"##");
        return "Connection created with"+" : "+connectionBean.getDatasourceUrl();
    }


    public List<Map<String,Object>> getTables()
    {
        return execute(SqlKeywords.SHOW+Symbols.SPACE+SqlKeywords.TABLES);
    }
    public String select(QueryDto queryDto)
    {
        StringBuilder strbuilder= new StringBuilder();
        strbuilder=strbuilder.append(SqlKeywords.SELECT+ Symbols.SPACE);
        if(queryDto.getSelectList().isEmpty())
        {
            return "";
        } else
        {
            int index=0;
            for(TableDetailsDto tdto: queryDto.getSelectList())
            {
                if(tdto.getColumnList().isEmpty())
                {
                    return "";
                }
                else
                {
                    int count = 0;
                    if(queryDto.getSelectList().size()==1 || index == queryDto.getSelectList().size()-1)
                    {
                        for (ColumnDetailsDto cdto : tdto.getColumnList()) {

                            if (count == (tdto.getColumnList().size() - 1) || (tdto.getColumnList().size() == 1))
                                strbuilder.append(tdto.getTableName() + "." + cdto.getColumnName() + Symbols.SPACE);
                            else
                                strbuilder.append(tdto.getTableName() + "." + cdto.getColumnName() + Symbols.COMMA);
                            count++;
                        }
                    }
                    else
                    {
                        for (ColumnDetailsDto cdto : tdto.getColumnList()) {

                            if (count == (tdto.getColumnList().size() - 1) || (tdto.getColumnList().size() == 1))
                                strbuilder.append(tdto.getTableName() + "." + cdto.getColumnName() + Symbols.SPACE);
                            else
                                strbuilder.append(tdto.getTableName() + "." + cdto.getColumnName() + Symbols.COMMA);
                            count++;
                        }
                        strbuilder.append(Symbols.COMMA);
                    }
                    index++;
                }
            }
        }
        return strbuilder.toString();
    }


    public String from(QueryDto queryDto, StringBuilder strbuilder)
    {
        strbuilder.append(SqlKeywords.FROM+Symbols.SPACE);
        int count2=0;
        for(TableDetailsDto tdto: queryDto.getSelectList())
        {
            if((queryDto.getSelectList().size()==1) || count2==(queryDto.getSelectList().size()-1))
                strbuilder.append(tdto.getTableName()+Symbols.SPACE);
            else
                strbuilder.append(tdto.getTableName()+Symbols.COMMA);
            count2++;
        }
        return strbuilder.toString();
    }


    public String where(QueryDto queryDto, StringBuilder strbuilder)
    {
        if(queryDto.getWhereList().isEmpty())
        {
            return strbuilder.append("").toString();
        }
        else {
            strbuilder.append(SqlKeywords.WHERE + Symbols.SPACE);
            for (TableDetailsDto tdto : queryDto.getWhereList()) {
                if (tdto.getColumnList().isEmpty())
                    return strbuilder.append("").toString();
                else {
                    int count3 = 0;
                    for (ColumnDetailsDto cdto : tdto.getColumnList()) {
                        if (cdto.getColumnType().equalsIgnoreCase("String")) {
                            if (count3 == (tdto.getColumnList().size() - 1) || (tdto.getColumnList().size() == 1))
                                strbuilder.append(tdto.getTableName()+"."+cdto.getColumnName() + Symbols.getSymbol(cdto.getCondition()) + "'" + cdto.getValue() + "'");
                            else
                                strbuilder.append(tdto.getTableName()+"."+cdto.getColumnName() + Symbols.getSymbol(cdto.getCondition()) + "'" + cdto.getValue() + "' " + Symbols.AND);
                        } else {
                            if (count3 == (tdto.getColumnList().size() - 1) || (tdto.getColumnList().size() == 1))
                                strbuilder.append(tdto.getTableName()+"."+cdto.getColumnName() + Symbols.getSymbol(cdto.getCondition()) + cdto.getValue());
                            else
                                strbuilder.append(tdto.getTableName()+"."+cdto.getColumnName() + Symbols.getSymbol(cdto.getCondition()) + cdto.getValue() + Symbols.SPACE + Symbols.AND);
                        }
                        count3++;
                    }
                }
            }
        }
        return strbuilder.toString();
    }


    public JdbcTemplate getTemplate()
    {
        return new JdbcTemplate(dataSource);
    }
    public List<Map<String ,Object>> execute(String query)
    {
        JdbcTemplate jdbcTemplate=getTemplate();
        log.info("##"+query+"##");
        return jdbcTemplate.queryForList(query);
    }

    public List<Map<String,Object>> makeQuery(QueryDto queryDto)
    {
        String query= select(queryDto);
        log.info("##"+query+"##");
        query=from(queryDto,new StringBuilder(query));
        log.info("##"+query+"##");
        query=where(queryDto,new StringBuilder(query));
        log.info("##"+query+"##");

        return execute(query);
    }

//    public List<Map<String,Object>> createTable()
//    {
//        JdbcTemplate jdbcTemplate=getTemplate();
//        String query="CREATE TABLE IF NOT EXISTS  VALUES(Id int NOT NULL AUTO_INCREMENT, Query varchar(255),PRIMARY KEY(Id))";
//        return jdbcTemplate.queryForList(query);
//    }

    public List<Map<String,Object>> insertQuery(String query)
    {
        String str="INSERT INTO QueryRecord (Query) VALUES("+query+")";
        return execute(str);
    }



}
