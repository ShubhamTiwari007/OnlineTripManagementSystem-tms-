package com.cg.tms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Hotel;
import com.cg.tms.exceptions.HotelNotFoundException;
import com.cg.tms.repositories.IHotelRepository;

/**
 * 
 * Class to implement CRUD operations from IHotelRepository
 * 
 */
@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository hotelRepository;

	/**
	 * to add Hotel in Database
	 * 
	 * @param hotel of Hotel type
	 * @return Hotel object which is stored
	 */
	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	/**
	 * to get All Hotels from Database
	 * 
	 * @return List of all Hotel
	 */
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	/**
	 * to Update Hotel in Database
	 * 
	 * @param hotel of Hotel type
	 * @return updated Hotel
	 */
	public Hotel updateHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	/**
	 * to Delete Hotel based on Id
	 * 
	 * @param id of integer type
	 * 
	 */
	public String delete(int id) {
		Hotel hotel = hotelRepository.findById(id)
				.orElseThrow(() -> new HotelNotFoundException("Cannot delete,No hotel with id: " + id + " found!!"));
		hotelRepository.deleteById(hotel.getId());
		return "Hotel with id: " + hotel.getId() + " deleted!!";
	}

	/**
	 * to get Hotel based on Id
	 * 
	 * @param id of int type
	 * @return Hotel whose id matches
	 */
	public Hotel getHotelById(int id) {
		return hotelRepository.findById(id)
				.orElseThrow(() -> new HotelNotFoundException("No hotel with id: " + id + " found!!"));
	}

	/**
	 * to get All Hotels based on City
	 * 
	 * @param city
	 * @return
	 */
	public List<Hotel> getHotelsByCityName(String city) {
		return hotelRepository.findByAddressContaining(city);
	}
}
