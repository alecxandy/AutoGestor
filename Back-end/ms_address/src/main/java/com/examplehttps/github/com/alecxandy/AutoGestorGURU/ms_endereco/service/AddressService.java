package com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.service;

import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.exception.IdentifierNotFoundException;
import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.model.Address;
import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> listAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new IdentifierNotFoundException());
    }

    public void deleteById(Long id) {
        addressRepository.findById(id).map(a -> {
            addressRepository.deleteById(id);
            return a;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    public Address update(Address address, Long id) {
        return addressRepository.findById(id).map(a -> {
            a.setId(id);
            a.setRoad(address.getRoad());
            a.setCity(address.getCity());
            a.setState(address.getState());
            a.setCountry(address.getCountry());
            a.setZipCode(address.getZipCode());
            addressRepository.save(a);
            return a;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }


    public List<Address> findByCityContaining(String city) {
        return addressRepository.findByCityContaining(city);
    }
}
