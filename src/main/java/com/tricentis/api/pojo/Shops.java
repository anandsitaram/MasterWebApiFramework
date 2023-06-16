package com.tricentis.api.pojo;


import com.tricentis.common.utils.RandomUtil;
import com.tricentis.common.utils.StringUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

@Builder
@Getter
@Setter

public class Shops {

    private String city;
    private String country;

    private long id;

    private String name;

    public static Shops buildRandomRequest(){

        return Shops.builder()
                .id(RandomUtil.getRandomNumber(1))
                .city(StringUtil.toCamelCase(RandomUtil.getRandomString(7)))
                .name(StringUtil.toCamelCase(RandomUtil.getRandomString(5)))
                .country(StringUtil.toCamelCase(RandomUtil.getRandomString(6)))
                .build();

    }
    public static Shops buildRequest(Map<String,Object> data){
        ShopsBuilder shopsBuilder = Shops.builder();

        if(Objects.nonNull(data.get("id"))){
            shopsBuilder= shopsBuilder.id((Long)data.get("id"));
        }
        if(Objects.nonNull(data.get("city"))){
            shopsBuilder= shopsBuilder.city(data.get("city").toString());
        }
        if(Objects.nonNull(data.get("country"))){
            shopsBuilder= shopsBuilder.country(data.get("country").toString());
        }
        if(Objects.nonNull(data.get("name"))){
            shopsBuilder= shopsBuilder.name(data.get("name").toString());
        }
        return shopsBuilder.build();

    }


}