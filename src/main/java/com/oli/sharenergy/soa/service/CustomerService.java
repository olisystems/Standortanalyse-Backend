package com.oli.sharenergy.soa.service;

import com.oli.sharenergy.soa.models.location.Customer;
import com.oli.sharenergy.soa.utilities.CustomerDBUtility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerDBUtility customerDBUtility;

    public int createCustomer(Customer customer){
        log.info("Going to create the Customer : " + customer.toString());
        customerDBUtility.saveCustomer(customer);
        return customer.getCustomerID();
    }

}