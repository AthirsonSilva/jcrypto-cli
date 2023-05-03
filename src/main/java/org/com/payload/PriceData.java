package org.com.payload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public record PriceData(String asset_id_base, String asset_id_quote, double rate, String time) {
    public PriceData() {
        this("", "", 0.0, "");
    }

    public PriceData fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, PriceData.class);
    }
}