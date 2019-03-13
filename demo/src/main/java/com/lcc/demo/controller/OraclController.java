package com.lcc.demo.controller;

import java.util.*;
import java.util.Map.Entry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OraclController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @RequestMapping("/Oracl")
    @ResponseBody
	  public List<Map<String, Object>> getDbType(){
		//String sqls = "insert into spring_user value(4,'houzi',47)";
	    String sql = "select * from ryxx where rownum<=6";
	    List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
	    for (Map<String, Object> map : list) {
	        Set<Entry<String, Object>> entries = map.entrySet( );
	            if(entries != null) {
	                Iterator<Entry<String, Object>> iterator = entries.iterator( );
	                while(iterator.hasNext( )) {
	                Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
	                Object key = entry.getKey( );
	                Object value = entry.getValue();
	                System.out.println(key+":"+value);
	            }
	        }
	    }
	    return list;
    }
}
