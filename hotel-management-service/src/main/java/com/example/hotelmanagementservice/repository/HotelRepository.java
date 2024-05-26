package com.example.hotelmanagementservice.repository;

import com.example.hotelmanagementservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findByName(String name);
}
