package com.sabarigrand.core.models.entities;

import com.sabarigrand.core.models.entities.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@Document(collection = "hotels")
@TypeAlias("sabariGrand.v1.hotels")
public class HotelEntity extends BaseEntity {

    @Field("name")
    private String name;

    @Field("location")
    private String location;

    @Field("description")
    private String description;

    @Field("amenities")
    private List<String> amenities;

}
