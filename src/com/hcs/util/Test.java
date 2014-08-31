package com.hcs.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hcs.model.GroupPriceSharing;
import com.hcs.model.GroupSharing;
import com.hcs.model.IndivisualPriceConfig;
import com.hcs.model.IndivisualSharingType;
import com.hcs.model.PriceConfig;
import com.hcs.model.SharingType;

public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        List<PriceConfig> configs = new ArrayList<PriceConfig>();
        IndivisualPriceConfig config = new IndivisualPriceConfig();
        config.setType(2);
        configs.add(config);

        GroupPriceSharing groupConfig = new GroupPriceSharing();
        Map<SharingType,SharingType> sharingTypes = new HashMap<SharingType, SharingType>();
        sharingTypes.put(new GroupSharing(1),new IndivisualSharingType());
        sharingTypes.put(new GroupSharing(2),new IndivisualSharingType());
        groupConfig.setTypes(sharingTypes);
        configs.add(groupConfig);

        ConfigHandler handler = new ConfigHandler();
        handler.setConfigs(configs);
        try {
//            System.out.println("asfasd");
//            String data  = "{\"type\":\"GroupSharing\",\"data\":null,\"groupCount\":1}";
//            SharingType sharing = JsonUtil.objectMapper.readValue(data,SharingType.class);
//            System.out.println(JsonUtil.objectMapper.writeValueAsString(sharing));
            String data = JsonUtil.objectMapper.writeValueAsString(handler);
            System.out.println(data);
            
            ConfigHandler parsedHandler = JsonUtil.objectMapper.readValue(data, ConfigHandler.class);
            data = JsonUtil.objectMapper.writeValueAsString(parsedHandler);
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
