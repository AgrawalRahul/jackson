package com.axisrooms.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Interface to interchange between JAVA/JSON formats.
 * 
 * 
 */
public interface JsonSZRnDSZR {
    public String serializeAsJson() throws IOException, JsonProcessingException;

    /**
     * Must be overriden by super class and its child classes. Each adding their
     * own fields. Child classes need to call the base class method first.
     * 
     */
    public void inJsonString(JsonGenerator g) throws IOException, JsonProcessingException;

    /**
     * Must be overriden by super class and its child classes. Each extracting
     * their own fields. Child classes need to extract first and if not found
     * call the super class method recursively.
     * 
     * 1) Try not to re populate the fields which are populated by Deserializer
     * during object construction. 2) Do not populate the fields which are
     * populated by database columns unless you are sure that such overwriting
     * would not result in inconsistent data under any scenario.
     * 
     * TODO: Implement a framework to avoid scenario 2 described above.
     * 
     * @param fieldName
     * @param jp
     * @throws IOException when resource not found or when the entity is not
     *             supposed to deserialized into a JAVA Object
     * @throws JsonProcessingException
     */
    public void populateFromJsonString(String fieldName, JsonParser jp) throws IOException, JsonProcessingException;
}
