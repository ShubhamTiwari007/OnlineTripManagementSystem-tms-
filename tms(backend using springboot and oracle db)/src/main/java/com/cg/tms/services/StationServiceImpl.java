package com.cg.tms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.tms.entities.Station;
import com.cg.tms.exceptions.StationNotFoundException;
import com.cg.tms.repositories.IStationRepository;

/**
 * 
 * Class to implement CRUD operations from IStationRepository
 * 
 */
@Service
public class StationServiceImpl implements IStationService {

	@Autowired
	private IStationRepository stationRepository;

	/**
	 * 
	 * @param station of Station type
	 */
	public Station addSatation(Station station) {
		return stationRepository.save(station);
	}

	/**
	 * 
	 * @return list of all stations
	 */
	public List<Station> getAllStation() {
		return stationRepository.findAll();
	}

	/**
	 * 
	 * @param station
	 * @return updated Station
	 */
	public Station updateStation(Station station) {
		return stationRepository.save(station);
	}

	/**
	 * 
	 * @param id of integer type
	 */
	public String deleteById(int id) {
		Station station = stationRepository.findById(id).orElseThrow(
				() -> new StationNotFoundException("Cannot delete,No station with id: " + id + " found!!"));
		stationRepository.deleteById(station.getId());
		return "Station with id: " + station.getId() + " deleted!!";
	}

	/**
	 * 
	 * @param id of integer type
	 * @return Station whose id matches
	 */
	public Station getStationById(int id) {
		return stationRepository.findById(id)
				.orElseThrow(() -> new StationNotFoundException("No station with id: " + id + " found!!"));
	}

	/**
	 * 
	 * @param code of String type
	 * @return Station whose code mathces
	 */
	public Station getStationByCode(String code) {
		Station station = stationRepository.findByCode(code);
		if (station == null)
			throw new StationNotFoundException("No station with Code: " + code + " found!!");
		return station;
	}

	/**
	 * 
	 * @param name of String type
	 * @return Station whose name mathces
	 */
	public Station getStationByName(String name) {
		Station station = stationRepository.findByName(name);
		if (station == null)
			throw new StationNotFoundException("No station with Name: " + name + " found!!");
		return stationRepository.findByName(name);
	}
}