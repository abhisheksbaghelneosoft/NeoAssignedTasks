package com.dbadmin.queryservice.constants;

import java.util.HashMap;
import java.util.Map;

public class Symbols {

    public static final String SPACE=" ";
    public static final String COMMA=",";
    public static final String AND="AND ";
    public static final String OR="OR ";

    public static String getSymbol(String name)
    {
        HashMap<String,String> hmap= new HashMap<>();
        hmap.put("EQUAL"," = ");
        hmap.put("NOT_EQUAL"," != ");
        hmap.put("GREATER_THAN"," > ");
        hmap.put("LESS_THAN"," < ");
        hmap.put("GREATER_OR_EQUAL"," >= ");
        hmap.put("LESS_OR_EQUAL"," <= ");
        String res="";
        for(Map.Entry<String,String>ent: hmap.entrySet())
        {
            if(name.equalsIgnoreCase(ent.getKey()))
            {
                res=ent.getValue();
            }
        }
        return res;
    }

}
