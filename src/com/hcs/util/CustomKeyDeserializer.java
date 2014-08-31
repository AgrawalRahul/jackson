package com.hcs.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.hcs.model.SharingType;

public class CustomKeyDeserializer extends KeyDeserializer{

    @Override
    public Object deserializeKey(String arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
        SharingType temp = JsonUtil.objectMapper.readValue(arg0,SharingType.class);
        return temp;
    }

}
