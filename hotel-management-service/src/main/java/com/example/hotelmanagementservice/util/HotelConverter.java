package com.example.hotelmanagementservice.util;

import com.example.hotelmanagementservice.dto.HotelCart;
import com.example.hotelmanagementservice.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelConverter {
    public Hotel fromHotelCart(HotelCart hotelCart){
        var hotel = new Hotel();
        hotel.setName(hotelCart.getName());
        hotel.setDescription(hotelCart.getDescription());
        return hotel;
    }
}
