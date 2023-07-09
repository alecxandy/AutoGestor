package com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.repository;

import com.examplehttps.github.com.alecxandy.AutoGestorGURU.ms_endereco.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByCityContaining(String city);
}
