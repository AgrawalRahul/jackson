package com.hcs.util;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.hcs.model.GroupPriceSharing;
import com.hcs.model.IndivisualPriceConfig;

@JsonTypeInfo(  
        use = JsonTypeInfo.Id.NAME,  
        include = JsonTypeInfo.As.PROPERTY,  
        property = "data_type")  
    @JsonSubTypes({  
        @Type(value = GroupPriceSharing.class, name = "cat"),  
        @Type(value = IndivisualPriceConfig.class, name = "dog") })
public class MixInHelper {

}
