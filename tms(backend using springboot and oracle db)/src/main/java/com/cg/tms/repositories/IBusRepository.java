package com.cg.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.tms.entities.Bus;

public interface IBusRepository extends JpaRepository<Bus, Integer> {

	public Bus findByBusNumber(String busNumber);

	public Bus findByDriver(String driver);

	public Bus findByConductor(String conductor);
}