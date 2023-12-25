package com.sabarigrand.core.repository.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class HotelRepositoryImpl implements ICustomHotelRepository{
    @Autowired
    MongoTemplate mongoTemplate;
}
