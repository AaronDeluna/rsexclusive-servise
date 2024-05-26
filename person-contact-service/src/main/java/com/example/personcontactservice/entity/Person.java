package com.example.personcontactservice.entity;

import com.example.personcontactservice.dto.PersonCart;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    @Email
    private String email;

    @NotEmpty
    @NotNull
    private String phone;

    @NotEmpty
    @NotNull
    private String description;


    public Person(String name, String email, String phone, String description) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.description = description;
    }

    public Person() {

    }

    public void fromPersonCart(PersonCart personCart) {
        this.name = personCart.getName();
        this.email = personCart.getEmail();
        this.phone = personCart.getPhone();
        this.description = personCart.getDescription();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email +
                ", description=" + description +
                '}';
    }
}
