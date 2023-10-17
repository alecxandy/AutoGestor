package com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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


    @JsonProperty(namespace = "Pais")
    @NotNull(message = "value cannot be null")
    private String country;

    @JsonProperty(namespace = "Estado")
    @NotNull(message = "value cannot be null")
    private String state;

    @JsonProperty(namespace = "Cidade")
    @NotNull(message = "value cannot be null")
    private String city;

    @JsonProperty(namespace = "Bairro")
    @NotNull(message = "value cannot be null")
    private String district;


    @JsonProperty(namespace = "Rua")
    @NotNull(message = "value cannot be null")
    private String road;

    @JsonProperty(namespace = "CEP")
    @NotNull(message = "value cannot be null")
    private String zipCode;

}
