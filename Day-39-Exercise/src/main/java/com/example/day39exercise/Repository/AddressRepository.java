package com.example.day39exercise.Repository;

import com.example.day39exercise.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressById(Integer id);

}
