package com.github.amirmehdi.springelastic.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lon",
        "lat"
})
@Data
public class Location {

    @JsonProperty("lon")
    private double lon;
    @JsonProperty("lat")
    private double lat;

}
