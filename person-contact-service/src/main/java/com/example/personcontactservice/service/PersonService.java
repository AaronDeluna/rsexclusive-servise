package com.example.personcontactservice.service;

import com.example.personcontactservice.entity.Person;
import com.example.personcontactservice.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    //Найти по имени и вернуть всю информацию
    public Person getPersonByName(String name){
        Person person = personRepository.findByName(name);
        if (person == null || !person.getEmail().equals(name)){
            //TODO Сделать выброс ошибки (Вернуть person по name)
        }
        return person;
    }

    @Transactional
    public void deleteByName(String name){
        Person person = personRepository.findByName(name);
        if (person == null || !person.getEmail().equals(name)){
            //TODO Сделать выброс ошибки (Удалить person по name)
        }
        personRepository.deleteByName(name);
    }

}
