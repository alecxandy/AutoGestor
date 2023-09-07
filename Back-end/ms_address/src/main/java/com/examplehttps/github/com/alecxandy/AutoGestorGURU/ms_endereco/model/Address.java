package com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "value cannot be null")
    private String country;

    @NotNull(message = "value cannot be null")
    private String state;

    @NotNull(message = "value cannot be null")
    private String city;

    @NotNull(message = "value cannot be null")
    private String district;

    @NotNull(message = "value cannot be null")
    private String road;

    @NotNull(message = "value cannot be null")
    private String zipCode;

}
