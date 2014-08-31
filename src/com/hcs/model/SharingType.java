package com.hcs.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(  
        use = JsonTypeInfo.Id.NAME,  
        include = JsonTypeInfo.As.PROPERTY,  
        property = "type")  
    @JsonSubTypes({  
        @Type(value = GroupSharing.class, name = "GroupSharing"),  
        @Type(value = IndivisualSharingType.class, name = "IndivisualSharingType") })  
public class SharingType{

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    

}
