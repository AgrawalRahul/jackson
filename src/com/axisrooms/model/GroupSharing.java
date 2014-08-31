package com.axisrooms.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

public class GroupSharing extends SharingType {

    private List<Integer> sharings;

    public GroupSharing() {
        super(SharingTypeType.GROUP);
    }

    public List<Integer> getSharings() {
        return sharings;
    }

    public void setSharings(List<Integer> sharings) {
        this.sharings = sharings;
    }

    @Override
    public void inJsonString(JsonGenerator g) throws IOException, JsonProcessingException {
        super.inJsonString(g);
        g.writeObjectField("sharings", getSharings());
    }

    @Override
    public void populateFromJsonString(String fieldName, JsonParser jp) throws IOException, JsonProcessingException {
        if ("sharings".equals(fieldName)) {
            jp.nextToken();
            sharings = jp.readValueAs(new TypeReference<List<Integer>>() {
            });
        }
        super.populateFromJsonString(fieldName, jp);
    }

}
