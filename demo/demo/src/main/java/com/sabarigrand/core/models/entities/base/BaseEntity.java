package com.sabarigrand.core.models.entities.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public abstract class BaseEntity implements Serializable {
    @Id
    private String id;

    @Field("created_date")
    private Date createdDate;

    @Field("modified_date")
    private Date modifiedDate;

}
