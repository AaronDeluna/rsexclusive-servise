package com.example.emailsubscriptionservice.service;

import com.example.emailsubscriptionservice.entity.ContactEmail;
import com.example.emailsubscriptionservice.exception.EmailNotFoundException;
import com.example.emailsubscriptionservice.repository.ContactEmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactEmailService {
    private final ContactEmailRepository contactEmailRepository;

    @Autowired
    public ContactEmailService(ContactEmailRepository contactEmailRepository) {
        this.contactEmailRepository = contactEmailRepository;
    }

    //Поиск email по email(Возвращает обьект)
    public ContactEmail getEmailByName(String email) {
        ContactEmail contactEmail = contactEmailRepository.findByEmail(email);
        if (contactEmail == null || !contactEmail.getEmail().equals(email)) {
            throw new EmailNotFoundException("Email not found: " + email);
        }
        return contactEmail;
    }

    //Удаление email по названию
    @Transactional
    public void deleteEmailByName(String email) {
        ContactEmail contactEmail = contactEmailRepository.findByEmail(email);
        if (contactEmail == null || !contactEmail.getEmail().equals(email)) {
            throw new EmailNotFoundException("Email not found: " + email);
        }
        contactEmailRepository.deleteByEmail(email);
    }

    //Изменение состояние подписки пользователя по email
    public void changeEmailSubscriptionByName(String email, Boolean newSubscription){
        ContactEmail contactEmail = contactEmailRepository.findByEmail(email);
        contactEmailRepository.updateSubscriptionByEmail(email, newSubscription);
    }
}

