package com.oli.sharenergy.soa.repository;

import com.oli.sharenergy.soa.models.location.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Optional<Customer> findCustomerBycustomerID(int customerID);

    List<Customer> findAll();

    Optional<Customer> findById(String locationID);
}
