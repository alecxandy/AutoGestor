package com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.service;

import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.exception.IdentifierNotFoundException;
import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.model.Address;
import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;


    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Long save(Address address) {
        return addressRepository.save(address).getId();
    }

    public Page<Address> listAll(Pageable pageable) {
        return addressRepository.findAll(pageable);
    }

    public Optional<Address> findById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(IdentifierNotFoundException::new);
        return Optional.of(address);
    }

    public void deleteById(Long id) {
        addressRepository.findById(id).map(a -> {
            addressRepository.deleteById(id);
            return a;
        }).orElseThrow(IdentifierNotFoundException::new);
    }

    public Address update(Address address) {
        return addressRepository.findById(address.getId()).map(a -> {
            a.setRoad(address.getRoad());
            a.setCity(address.getCity());
            a.setState(address.getState());
            a.setCountry(address.getCountry());
            a.setZipCode(address.getZipCode());
            addressRepository.save(a);
            return a;
        }).orElseThrow(IdentifierNotFoundException::new);
    }


}
