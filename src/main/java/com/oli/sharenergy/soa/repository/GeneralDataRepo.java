package com.oli.sharenergy.soa.repository;

import com.oli.sharenergy.soa.models.ode.GeneralData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralDataRepo extends JpaRepository<GeneralData, Integer> {
}
