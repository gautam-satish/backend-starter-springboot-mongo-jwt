package com.sabarigrand.core.repository.hotel;

import com.sabarigrand.core.models.entities.HotelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<HotelEntity, String>, ICustomHotelRepository {
}
