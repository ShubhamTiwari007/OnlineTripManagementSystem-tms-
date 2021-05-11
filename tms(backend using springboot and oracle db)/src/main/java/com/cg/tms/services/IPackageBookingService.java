package com.cg.tms.services;

import java.time.LocalDate;
import java.util.List;

import com.cg.tms.entities.PackageBooking;

public interface IPackageBookingService {

	public PackageBooking addPackageBooking(PackageBooking packageBooking);

	public List<PackageBooking> getAllPackageBookings();

	public PackageBooking updatePackageBooking(PackageBooking packageBooking);

	public String deletePackageBookingById(int id);

	public PackageBooking getPackageBookingById(int id);

	public List<PackageBooking> getAllPackageBookingsByCustomerId(int id);

	public List<PackageBooking> getAllPackageBookingByBookingDate(LocalDate bookingDate);

}