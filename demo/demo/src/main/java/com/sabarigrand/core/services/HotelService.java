package com.sabarigrand.core.services;

import com.sabarigrand.core.models.entities.HotelEntity;
import com.sabarigrand.core.models.requests.HotelRequest;
import com.sabarigrand.core.models.responses.HotelResponse;

import java.util.List;

public interface HotelService {
 List<HotelResponse> fetchAllHotels();

 HotelResponse createHotel(HotelRequest request);

 HotelResponse transformResponse(HotelEntity hotelEntity);
}
