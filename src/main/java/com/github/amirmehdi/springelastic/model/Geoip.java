package com.github.amirmehdi.springelastic.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "country_iso_code",
        "location",
        "region_name",
        "continent_name",
        "city_name"
})
@Data
public class Geoip {

    @JsonProperty("country_iso_code")
    private String countryIsoCode;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("region_name")
    private String regionName;
    @JsonProperty("continent_name")
    private String continentName;
    @JsonProperty("city_name")
    private String cityName;

}
