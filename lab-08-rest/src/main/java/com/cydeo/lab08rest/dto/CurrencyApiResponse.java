package com.cydeo.lab08rest.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CurrencyApiResponse {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("terms")
    private String terms;
    @JsonProperty("privacy")
    private String privacy;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("source")
    private String source;
    private Map<String, Double> quotes;
}
