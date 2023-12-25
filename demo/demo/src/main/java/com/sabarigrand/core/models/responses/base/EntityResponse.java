package com.sabarigrand.core.models.responses.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public abstract class EntityResponse implements Serializable {
    private String id;
    private Date createdDate;
    private Date modifiedDate;

}
