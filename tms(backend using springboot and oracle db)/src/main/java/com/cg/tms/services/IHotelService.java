package com.cg.tms.services;

import java.util.List;

import com.cg.tms.entities.Hotel;

public interface IHotelService {

	public Hotel addHotel(Hotel hotel);

	public List<Hotel> getAllHotel();

	public Hotel updateHotel(Hotel hotel);

	public String delete(int id);

	public Hotel getHotelById(int id);

	public List<Hotel> getHotelsByCityName(String city);

}