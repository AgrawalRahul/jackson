package com.axisrooms.util;

import java.io.IOException;

import com.axisrooms.model.SharingType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class SharingTypeJsonSZR extends JsonSerializer<SharingType> {

    @Override
    public void serialize(SharingType configuration, JsonGenerator g, SerializerProvider arg2)
            throws IOException, JsonProcessingException {
        g.writeStartObject();
        configuration.inJsonString(g);
        g.writeEndObject();
    }

}
