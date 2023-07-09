package com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.controller;

import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.model.Address;
import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @PostMapping
    public ResponseEntity<Address> save(@RequestBody @Valid Address address) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
    }

    @GetMapping
    public ResponseEntity<List<Address>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        addressService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@RequestBody @Valid Address address, @PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.update(address, id));
    }

    @GetMapping("search/{city}")
    public ResponseEntity<List<Address>> findByNameContaining(@PathVariable(name = "city") @Valid String city) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findByCityContaining(city));
    }

}
