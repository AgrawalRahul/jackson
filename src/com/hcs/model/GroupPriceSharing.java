package com.hcs.model;

import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hcs.util.CunstomKeySerializer;
import com.hcs.util.CustomKeyDeserializer;

public class GroupPriceSharing extends PriceConfig{
    
    @JsonSerialize(keyUsing = CunstomKeySerializer.class)
    @JsonDeserialize(keyUsing = CustomKeyDeserializer.class)
    private Map<SharingType,SharingType> types;

    public Map<SharingType,SharingType> getTypes() {
        return types;
    }

    public void setTypes(Map<SharingType,SharingType> types) {
        this.types = types;
    }

}
