package com.oli.sharenergy.soa.utilities;


import com.oli.sharenergy.soa.models.exceptions.CustomerCollectionException;
import com.oli.sharenergy.soa.models.exceptions.CustomerUtilityException;
import com.oli.sharenergy.soa.models.exceptions.LocationUitilityException;
import com.oli.sharenergy.soa.models.location.Customer;
import com.oli.sharenergy.soa.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class CustomerDBUtility {

    private final CustomerRepo customerRepo;

    public void saveCustomer(Customer customer) {
        try {
            log.info("Successfully saved Customer in DB.");
            customerRepo.save(customer);
        } catch (Exception e) {
            log.error("Something happened during saving the Customer data: " + customer);
            log.error("Exception: " + e);
            throw new CustomerCollectionException();
        }
    }

    public Optional<Customer> findCustomerBycustomerID(int customerID){
        Optional<Customer> customer = customerRepo.findById(customerID);
        if (customer.isEmpty()) {
            log.info("Can't find Customer with CustomerID: " + customerID);
            throw new CustomerUtilityException("Exception occurred while getting the Customer from the CustomerID");
        }
        return customer;
    }

    public Iterable<Customer> findAll(){
        try {
            return customerRepo.findAll();
        } catch (Exception e){
            log.error("Unknown Error occured, please Inform the OLI-Team");
            throw new LocationUitilityException("Unknown Exception occured while finding all existing Customers ");
        }

    }

    public Optional<Customer> findCustomerBylocationID(String locationID){
        Optional<Customer> customer = customerRepo.findById(locationID);
        if (customer.isEmpty()) {
            log.info("Can't find Customer connected with that LocationID: " + locationID);
            throw new CustomerUtilityException("Exception occurred while getting the Customer from the LocationID");
        }
        return customer;
    }
}
