package com.example.hotelmanagementservice.controller;

import com.example.hotelmanagementservice.dto.HotelCart;
import com.example.hotelmanagementservice.entity.Hotel;
import com.example.hotelmanagementservice.repository.HotelRepository;
import com.example.hotelmanagementservice.util.HotelConverter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "hotel-controller")
@Slf4j
@CrossOrigin
@RestController()
@RequiredArgsConstructor
public class HotelController {

    private final HotelRepository hotelRepository;
    private final HotelConverter hotelConverter;

    //Hotel create Methods

    @PostMapping("/api/hotel/create")
    public ResponseEntity<String> createHotel(@Valid @RequestBody HotelCart hotelCart) {
        hotelRepository.save(hotelConverter.fromHotelCart(hotelCart));
        return ResponseEntity.ok("Новый отель успешно сохранен!");
    }

    //Hotel get Methods

    @SneakyThrows
    @GetMapping("/api/hotel/get/all")
    public List<Hotel> getAllPerson() {
        return hotelRepository.findAll();
    }

    @GetMapping("/api/hotel/get/id")
    public Hotel getHotel(@RequestParam Long id) {
        return hotelRepository.findById(id).orElseThrow();
    }

    //Hotel Delete Methods not stop

    @DeleteMapping("/api/hotel/delete/all")
    public ResponseEntity<Value> deleteHotelAll() {
        hotelRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/hotel/delete/id")
    public ResponseEntity<Value> deleteHotelId(@RequestParam Long id) {
        hotelRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/hotel/delete/name")
    public ResponseEntity<String> deleteHotelByName(@RequestParam String name){
        Hotel hotel = hotelRepository.findByName(name);
        hotelRepository.deleteById(hotel.getId());
        return ResponseEntity.ok("Отель успешно удален!");
    }
}
