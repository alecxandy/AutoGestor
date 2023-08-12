package com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.controller;

import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.model.Address;
import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody  Address address) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
    }

    @GetMapping
    public ResponseEntity<Page<Address>> listAll(Pageable  pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.listAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Address>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        addressService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity<Address> update(@RequestBody Address address) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.update(address));
    }


}
