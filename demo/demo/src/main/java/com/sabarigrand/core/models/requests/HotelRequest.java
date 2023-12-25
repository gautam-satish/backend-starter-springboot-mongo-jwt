package com.sabarigrand.core.models.requests;

import com.sabarigrand.core.models.entities.HotelEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelRequest {
    private String name;
    private String location;
    private String description;
    private List<String> amenities;
    //private List<RoomResponse> rooms;
}
