package com.oli.sharenergy.soa.repository;

import com.oli.sharenergy.soa.models.ode.ODE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ODERepo extends JpaRepository<ODE, Integer> {
}
