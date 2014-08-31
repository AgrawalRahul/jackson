package com.axisrooms.util;

import java.io.IOException;

import com.axisrooms.model.SharingType;
import com.axisrooms.model.SharingType.SharingTypeType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SharingTypeJsonDSZR extends JsonDeserializer<SharingType> {

    @Override
    public SharingType deserialize(JsonParser jp, DeserializationContext arg1) throws IOException,
            JsonProcessingException {
        jp.nextToken();
        String fieldName = jp.getCurrentName();
        if (!"type".equals(fieldName)) {
            throw new RuntimeException("The first field in serialization should be : type, Currently it is" + fieldName);
        }
        jp.nextToken();
        SharingTypeType type = SharingTypeType.getType(jp.readValueAs(int.class));
        final SharingType configuration = type.getSharingType();
        while (jp.getCurrentToken() != JsonToken.END_OBJECT) {
            jp.nextToken();
            fieldName = jp.getCurrentName();
            configuration.populateFromJsonString(fieldName, jp);
        }
        return configuration;
    }

}
