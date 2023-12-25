package com.sabarigrand.core.models.responses;

import com.sabarigrand.core.models.entities.HotelEntity;
import com.sabarigrand.core.models.responses.base.EntityResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelResponse extends EntityResponse {
    private String name;
    private String location;
    private String description;
    private List<String> amenities;
    //private List<RoomResponse> rooms;

    public static HotelResponse full(HotelEntity hotelEntity){
      if(hotelEntity == null){
          return null;
      }

      HotelResponse response = new HotelResponse();
      response.setId(hotelEntity.getId());
      response.setName(hotelEntity.getName());
      response.setLocation(hotelEntity.getLocation());
      response.setDescription(hotelEntity.getDescription());
      response.setAmenities(hotelEntity.getAmenities());
      response.setCreatedDate(hotelEntity.getCreatedDate());
      response.setModifiedDate(hotelEntity.getModifiedDate());

      return response;
    }

    public static HotelResponse simple(HotelEntity hotelEntity){
        if(hotelEntity == null){
            return null;
        }

        HotelResponse response = new HotelResponse();
        response.setName(hotelEntity.getName());
        response.setLocation(hotelEntity.getLocation());
        response.setDescription(hotelEntity.getDescription());
        response.setAmenities(hotelEntity.getAmenities());
        return response;
    }
}
