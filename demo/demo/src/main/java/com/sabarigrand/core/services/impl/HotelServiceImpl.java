package com.sabarigrand.core.services.impl;

import com.sabarigrand.core.models.entities.HotelEntity;
import com.sabarigrand.core.models.requests.HotelRequest;
import com.sabarigrand.core.models.responses.HotelResponse;
import com.sabarigrand.core.repository.hotel.HotelRepository;
import com.sabarigrand.core.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<HotelResponse> fetchAllHotels() {

        List<HotelEntity> hotelEntities = hotelRepository.findAll();

        List<HotelResponse> hotelResponses = hotelEntities.stream()
                .map(this::transformResponse)
                .collect(Collectors.toList());

        return hotelResponses;
    }

    @Override
    public HotelResponse createHotel(HotelRequest request) {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setName(request.getName());
        hotelEntity.setDescription(request.getDescription());
        hotelEntity.setLocation(request.getLocation());
        hotelEntity.setCreatedDate(new Date());
        hotelEntity.setModifiedDate(new Date());
//        hotelEntity.setAmenities(request.getAmenities());

        HotelEntity hotel = hotelRepository.save(hotelEntity);
        return transformResponse(hotel);
    }

    @Override
    public HotelResponse transformResponse(HotelEntity hotelEntity) {
        return HotelResponse.full(hotelEntity);
    }
}
