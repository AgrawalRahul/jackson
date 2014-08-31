package com.hcs.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    
    public static ObjectMapper objectMapper;
    
    static{
        objectMapper();
    }
    
    private static void objectMapper(){
        objectMapper = new ObjectMapper();
    }

}
