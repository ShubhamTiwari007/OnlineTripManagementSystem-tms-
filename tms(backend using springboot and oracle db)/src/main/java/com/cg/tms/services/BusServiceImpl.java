package com.cg.tms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.tms.entities.Bus;
import com.cg.tms.exceptions.BusNotFoundException;
import com.cg.tms.repositories.IBusRepository;

/**
 * 
 * Class to implement CRUD operations from IBusRepository
 * 
 */
@Service
public class BusServiceImpl implements IBusService {

	@Autowired
	private IBusRepository busRepository;

	/**
	 * to add Bus in Database
	 * 
	 * @param bus of Bus type
	 * @return bus which is stored
	 */
	public Bus addBus(Bus bus) {
		return busRepository.save(bus);
	}

	/**
	 * to Get All Buses from Database
	 * 
	 * @return List of all Buses
	 */
	public List<Bus> getAllBus() {
		return busRepository.findAll();
	}

	/**
	 * to Update Bus
	 * 
	 * @param bus of Bus type
	 * @return updated Bus
	 */
	public Bus updateBus(Bus bus) {
		return busRepository.save(bus);
	}

	/**
	 * to Delete by based on Id
	 * 
	 * @param id of integer type
	 * @return message after deletion
	 */
	public String delete(int id) {
		Bus bus = busRepository.findById(id)
				.orElseThrow(() -> new BusNotFoundException("Cannot delete,bus with id: " + id + " Not found!!"));
		busRepository.deleteById(bus.getId());
		return "Bus with id: " + bus.getId() + " deleted!!";
	}

	/**
	 * to Get Bus based on Id
	 * 
	 * @param id of int type
	 * @return Bus whose id matches
	 */
	public Bus getBusById(int id) {
		return busRepository.findById(id)
				.orElseThrow(() -> new BusNotFoundException("No bus with id: " + id + " found!!"));
	}

	/**
	 * to Get Bus based bus number
	 * 
	 * @param busNumber
	 * @return Bus whose bus number matches
	 */
	public Bus getBusByBusNumber(String busNumber) {
		Bus bus = busRepository.findByBusNumber(busNumber);
		if (bus == null)
			throw new BusNotFoundException("No bus with Bus Number: " + busNumber + " found!!");
		return bus;
	}
}