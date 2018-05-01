package com.milind.logmasking.logmasking.masking;

import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

public class MaskingUtil {

    private static final Configuration configuration = Configuration.builder()
            .jsonProvider(new JacksonJsonNodeJsonProvider())
            .mappingProvider(new JacksonMappingProvider())
            .build();

    public static Object mask(Object json){
        JsonNode updatedJson =   JsonPath.using(configuration).parse(json.toString()).set("$.userId", "XXXXXXXXXX").json();
        updatedJson = JsonPath.using(configuration).parse(updatedJson).set("$.personalDetails.firstName", "XXXXXXXXXX").json();
        updatedJson = JsonPath.using(configuration).parse(updatedJson).set("$.personalDetails.lastName", "XXXXXXXXXX").json();
        updatedJson = JsonPath.using(configuration).parse(updatedJson).set("$.personalDetails.DOB", "XXXXXXXXXX").json();
        updatedJson = JsonPath.using(configuration).parse(updatedJson).set("$.personalDetails.SSN", "XXXXXXXXXX").json();
        updatedJson = JsonPath.using(configuration).parse(updatedJson).set("$.addressHistory[*].zipcode", "XXXXXXXXXX").json();
        return  updatedJson;
    }

    public static  boolean isBracesPresent(String log){

        if(log.indexOf("{")>0){
            return true;
        } else if(log.indexOf("[")>0){
            return  true;
        } else if(log.indexOf("(")>0){
            return  true;
        }
        return  false;
    }

}
