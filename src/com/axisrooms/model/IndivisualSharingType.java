package com.axisrooms.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;

public class IndivisualSharingType extends SharingType {

    private int sharingCount = 1;

    public IndivisualSharingType() {
        super(SharingTypeType.INDIVISUAL);
    }

    public int getSharingCount() {
        return sharingCount;
    }

    public void setSharingCount(int sharingCount) {
        this.sharingCount = sharingCount;
    }

    @Override
    public void inJsonString(JsonGenerator g) throws IOException, JsonProcessingException {
        super.inJsonString(g);
        g.writeNumberField("sharingCount", getSharingCount());
    }

    @Override
    public void populateFromJsonString(String fieldName, JsonParser jp) throws IOException, JsonProcessingException {
        if ("sharingCount".equals(fieldName)) {
            jp.nextToken();
            setSharingCount(jp.readValueAs(Integer.class));
        } else {
            super.populateFromJsonString(fieldName, jp);
        }

    }

}
