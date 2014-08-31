package com.axisrooms.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.axisrooms.util.JsonSZRnDSZR;
import com.axisrooms.util.JsonUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;

public class SharingType implements JsonSZRnDSZR{

    private String data = "Rahul";
    private SharingTypeType type;
    
    protected SharingType(SharingTypeType type){
        this.type = type;
    }

    public enum SharingTypeType {

        INDIVISUAL(1) {
            @Override
            public SharingType getSharingType() {
                return new IndivisualSharingType();
            }
        }, GROUP(2) {
            @Override
            public SharingType getSharingType() {
                return new GroupSharing();
            }
        };
        
        private final int id;

        private SharingTypeType(int id) {
            this.id = id;
        }
        
        public abstract SharingType getSharingType();

        public int getId() {
            return id;
        }
        
        private static final Map<Integer, SharingTypeType> sharingMap = new HashMap<Integer, SharingType.SharingTypeType>();
        static{
            for (SharingTypeType sharingTypeType : SharingTypeType.values()) {
                sharingMap.put(sharingTypeType.getId(), sharingTypeType);
            }
        }
        
        public static SharingTypeType getType(int id){
            return sharingMap.get(id);
        }
         
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public SharingTypeType getType() {
        return type;
    }

    public void setType(SharingTypeType type) {
        this.type = type;
    }

    @Override
    public String serializeAsJson() throws IOException, JsonProcessingException {
        return JsonUtil.getDefaultObjectMapper().writeValueAsString(this);
    }

    @Override
    public void inJsonString(JsonGenerator g) throws IOException, JsonProcessingException {
         g.writeNumberField("type",getType().getId());
        g.writeStringField("data", getData());
        
    }

    @Override
    public void populateFromJsonString(String fieldName, JsonParser jp) throws IOException, JsonProcessingException {
        if ("data".equals(fieldName)) {
            jp.nextToken();
            setData(jp.readValueAs(String.class));
        }   
    }
}
