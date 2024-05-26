package com.example.emailsubscriptionservice.repository;

import com.example.emailsubscriptionservice.entity.ContactEmail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ContactEmailRepository extends JpaRepository<ContactEmail, Integer> {
    ContactEmail findByEmail(String email);
    void deleteByEmail(String email);
    @Modifying
    @Transactional
    @Query("UPDATE ContactEmail ce SET ce.subscription = :newSubscription WHERE ce.email = :email")
    void updateSubscriptionByEmail(String email, Boolean newSubscription);
}
