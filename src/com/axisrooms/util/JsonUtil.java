package com.axisrooms.util;

import java.io.IOException;
import java.util.List;

import com.axisrooms.model.SharingType;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * 
 * Make entry of all classes using Jackson
 */
public class JsonUtil {
    // private static final Logger s_logger = Logger.getLogger(JsonUtil.class);
    private static ObjectMapper s_mapper;
    private static JsonFactory  s_factory;

    static {
        initialize();
    }

    public static synchronized void initialize() {
        // s_logger.info("Initializing JsonUtil.");
        try {
            s_mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule("HCSModule");
            module.addSerializer(SharingType.class, new SharingTypeJsonSZR());
            module.addDeserializer(SharingType.class, new SharingTypeJsonDSZR());
            /*
             * ClearTrip
             */

            s_mapper.registerModule(module);
            /**
             * Important, writing calendars as time stamps prevents default time
             * zone based date changes.
             */

            /**
             * Registering Module for Jesque Object Mapper TODO: This does'nt
             * seem to affect Jesque's mapper.... Need to think of a strategy in
             * which both the internal as well as jeque's object mapper have
             * exactly same configuration. Or is that an overkill?
             */

            // s_logger.info("Initialized JsonUtil.");
        } catch (Exception e) {
            // s_logger.fatal("FATAL: Error Initializing JsonUtil.", e);
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    public static JsonFactory getDefaultJsonFactory() {
        return s_factory;
    }

    public static ObjectMapper getDefaultObjectMapper() {
        return s_mapper;
    }

    public static String toJsonString(List<Integer> keys) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean and = false;
        if (keys != null && keys.size() > 0) {
            for (Integer key : keys) {
                if (and) {
                    sb.append(",");
                }
                sb.append(getDefaultObjectMapper().writeValueAsString(key));
                and = true;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static List<Integer> integerListfromJson(String jsonString) throws Exception {
        List<Integer> integers = JsonUtil.getDefaultObjectMapper().readValue(jsonString,
                new TypeReference<List<Integer>>() {
                });
        return integers;
    }

    // public static <T extends JsonSZRnDSZR> T getJsonClone(T original) {
    // try {
    // T clone =
    // JsonUtil.getDefaultObjectMapper().readValue(original.serializeAsJson(),
    // new TypeReference<T>() {
    // });
    // return clone;
    // } catch (Exception e) {
    // s_logger.error("Error In Json Cloning" + original);
    // return null;
    // }
    // }

    public static void main(String[] args) {
        initialize();
        String response = null;
        try {
            System.out.println(getDefaultObjectMapper().writeValueAsString(response));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
