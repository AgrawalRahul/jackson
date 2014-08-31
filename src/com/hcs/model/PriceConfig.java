package com.hcs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;



@JsonTypeInfo(  
        use = JsonTypeInfo.Id.NAME,  
        include = JsonTypeInfo.As.PROPERTY,  
        property = "data_type")  
    @JsonSubTypes({  
        @Type(value = GroupPriceSharing.class, name = "GroupPriceSharing"),  
        @Type(value = IndivisualPriceConfig.class, name = "IndivisualPriceConfig") })
public abstract class PriceConfig {
    
    @JsonIgnore
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}
