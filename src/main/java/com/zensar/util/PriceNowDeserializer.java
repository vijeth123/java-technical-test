package com.zensar.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * This deserializer is essential because the value of 'now' field in the input json is
 * sometimes a simple string such as: "59.00"
 * and sometimes it's a json itself, such as: {"from":"55.00","to":"100.00"}
 *
 * When 'now' field is a json, I am extracting 'to' field from it and setting it to 'priceNow' field of the target.
 */
public class PriceNowDeserializer extends JsonDeserializer {

    @Override
    public String deserialize(JsonParser jp, DeserializationContext ctxt){
        JsonNode node = null;
        try {
            node = jp.getCodec().readTree(jp);
        } catch (IOException e) {
            return "0";
        }

        if(node.isTextual()){
            return node.asText();
        }
        return node.get("to").asText();
    }
}
