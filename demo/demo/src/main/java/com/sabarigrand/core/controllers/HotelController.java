package com.sabarigrand.core.controllers;

import com.sabarigrand.core.models.requests.HotelRequest;
import com.sabarigrand.core.models.responses.HotelResponse;
import com.sabarigrand.core.services.HotelService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelResponse>> getAllHotels(HttpServletRequest servletRequest){
        List<HotelResponse> response = hotelService.fetchAllHotels();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<HotelResponse> createHotel(@RequestBody HotelRequest request, HttpServletRequest servletRequest){
        HotelResponse response = hotelService.createHotel(request);
        return ResponseEntity.ok(response);
    }
}
