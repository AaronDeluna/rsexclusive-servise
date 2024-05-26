package com.example.emailsubscriptionservice.utils;

import com.example.emailsubscriptionservice.dto.ContactEmailCart;
import com.example.emailsubscriptionservice.entity.ContactEmail;
import org.springframework.stereotype.Component;

@Component
public class ContactEmailConverter {

    public ContactEmail fromContactEmailCart(ContactEmailCart contactEmailCart){
        var contactEmail = new ContactEmail();
        contactEmail.setEmail(contactEmailCart.getEmail());
        return contactEmail;
    }
}