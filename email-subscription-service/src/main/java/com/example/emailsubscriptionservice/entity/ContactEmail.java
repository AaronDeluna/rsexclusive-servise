package com.example.emailsubscriptionservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "emails")
@AllArgsConstructor
@NoArgsConstructor
public class ContactEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(unique = true)
    @Email
    private String email;

    @NotNull
    private Boolean subscription = true;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;

    @PrePersist
    protected void onCreate() {
        dateTime = LocalDateTime.now().withNano(0);
    }

    @Override
    public String toString() {
        return "ContactEmail{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
