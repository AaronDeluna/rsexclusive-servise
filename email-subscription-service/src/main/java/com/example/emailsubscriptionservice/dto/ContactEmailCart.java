package com.example.emailsubscriptionservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@RequiredArgsConstructor
@Data
public class ContactEmailCart {

    @NotEmpty
    @Column(unique = true)
    @Email
    private String email;

    @NotNull
    private Boolean subscription = true;
}
