package com.example.emailsubscriptionservice.controller;


import com.example.emailsubscriptionservice.dto.ContactEmailCart;
import com.example.emailsubscriptionservice.entity.ContactEmail;
import com.example.emailsubscriptionservice.exception.EmailNotFoundException;
import com.example.emailsubscriptionservice.repository.ContactEmailRepository;
import com.example.emailsubscriptionservice.service.ContactEmailService;
import com.example.emailsubscriptionservice.utils.ContactEmailConverter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "email-controller")
@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class EmailController {

    private final ContactEmailRepository contactEmailRepository;
    private final ContactEmailConverter contactEmailConverter;
    private final ContactEmailService contactEmailService;


    //Email set Methods

    @PostMapping("/api/email/create")
    public ResponseEntity<String> createEmail(@Valid @RequestBody ContactEmailCart contactEmailCart) {
        contactEmailRepository.save(contactEmailConverter.fromContactEmailCart(contactEmailCart));
        return ResponseEntity.ok("Новый email успешно сохранен!");
    }

    //Email get Methods

    @GetMapping("/api/email/get/all")
    public List<ContactEmail> getAllEmail() {
        return contactEmailRepository.findAll();
    }


    @GetMapping("/api/email/get/id")
    public ContactEmail getEmailOrId(@RequestParam int id) {
        return contactEmailRepository.findById(id).orElseThrow();
    }


    @GetMapping("/api/email/get/by/name")
    public ResponseEntity<ContactEmail> getEmailName(@RequestParam String email) {
        try {
            ContactEmail contactEmail = contactEmailService.getEmailByName(email);
            return ResponseEntity.ok(contactEmail);
        } catch (EmailNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //Email delete Methods

    @DeleteMapping("/api/email/delete/all")
    public ResponseEntity<Value> deleteAllEmail() {
        contactEmailRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/email/delete/id")
    public ResponseEntity<Value> deleteEmail(@RequestParam int id) {
        contactEmailRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/email/delete/by/name")
    public ResponseEntity<?> deleteByEmail(@RequestParam String email) {
        try {
            contactEmailService.deleteEmailByName(email);
            return ResponseEntity.ok("Email успешно удален: " + email + "!");
        } catch (EmailNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found: " + email);
        }
    }

    //Изменение статуса подписки - subscription

    @PutMapping("/api/email/change/email/subscription/by/name")
    public ResponseEntity<?> changeEmailSubscriptionOrName(@Valid @RequestParam String email, Boolean newSubscription){
        contactEmailService.changeEmailSubscriptionByName(email, newSubscription);
        return ResponseEntity.ok("Статус подписки успешно изменён!");
    }
}
