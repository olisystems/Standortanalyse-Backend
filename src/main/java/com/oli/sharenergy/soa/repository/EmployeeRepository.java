package com.oli.sharenergy.soa.repository;

import com.oli.sharenergy.soa.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
