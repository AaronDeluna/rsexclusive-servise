package com.example.personcontactservice.utils;

import com.example.personcontactservice.dto.PersonCart;
import com.example.personcontactservice.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {

    public Person fromPersonCart(PersonCart personCart) {
        var person = new Person();
        person.setName(personCart.getName());
        person.setEmail(personCart.getEmail());
        person.setPhone(personCart.getPhone());
        person.setDescription(personCart.getDescription());
        return person;
    }
}
