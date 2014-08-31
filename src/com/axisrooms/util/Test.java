package com.axisrooms.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.axisrooms.model.GroupSharing;
import com.axisrooms.model.IndivisualSharingType;
import com.axisrooms.model.SharingType;
import com.fasterxml.jackson.core.type.TypeReference;

public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        List<SharingType> sharings = new ArrayList<SharingType>();
        sharings.add(new IndivisualSharingType());
        Integer[] sharingData = { 1, 2, 3 };
        GroupSharing sharing = new GroupSharing();
        sharing.setSharings(Arrays.asList(sharingData));
        sharings.add(sharing);
        try {
            String data = JsonUtil.getDefaultObjectMapper().writeValueAsString(sharings);
            System.out.println(data);

            List<SharingType> parsedHandler = JsonUtil.getDefaultObjectMapper().readValue(data,
                    new TypeReference<List<SharingType>>() {
                    });
            data = JsonUtil.getDefaultObjectMapper().writeValueAsString(parsedHandler);
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
