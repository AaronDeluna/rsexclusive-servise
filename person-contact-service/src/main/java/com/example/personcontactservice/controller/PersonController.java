package com.example.personcontactservice.controller;

import com.example.personcontactservice.dto.PersonCart;
import com.example.personcontactservice.entity.Person;
import com.example.personcontactservice.repository.PersonRepository;
import com.example.personcontactservice.utils.PersonConverter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "person-controller")
@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;

    //Person create Methods

    @PostMapping("/api/person/service/create")
    public ResponseEntity<String> createPerson(@Valid @RequestBody PersonCart personCart) {
        personRepository.save(personConverter.fromPersonCart(personCart));
        return ResponseEntity.ok("Person успешно сохранен!");
    }

    //Person get Methods

    @SneakyThrows
    @GetMapping("/api/person/service/get/all")
    public List<Person> getAllPerson()  {
        return personRepository.findAll();
    }

    @GetMapping("/api/person/service/get/id")
    public Person getPerson(@RequestParam int id) {
        return personRepository.findById(id).orElseThrow();
    }

    //Person delete Methods

    @DeleteMapping("/api/person/service/delete/all")
    public ResponseEntity<Value> deleteAllPerson(){
        personRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/person/service/delete/id")
    public ResponseEntity<Value> deletePerson(@RequestParam int id) {
        personRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
