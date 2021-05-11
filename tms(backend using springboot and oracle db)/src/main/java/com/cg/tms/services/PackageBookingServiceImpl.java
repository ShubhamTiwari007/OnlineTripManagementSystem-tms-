package com.cg.tms.services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.tms.entities.PackageBooking;
import com.cg.tms.repositories.IPackageBookingRepository;

/**
 * 
 * Class to implement CRUD operations from IPackageBookingRepository
 * 
 */
@Service
public class PackageBookingServiceImpl implements IPackageBookingService {

	@Autowired
	private IPackageBookingRepository packageBookingRepository;

	/**
	 * to store package booking in database.
	 * 
	 * @param packageBooking
	 */
	public PackageBooking addPackageBooking(PackageBooking packageBooking) {
		if(!PaymentService.isPaymentDone().equals("Payment Successfully Done !!, Booking confirmed")) {
			// redirect to payment failed page
		}
		packageBooking.setAmount((packageBooking.getHotel().getRent() * packageBooking.getNoOfCustomers()) + 2500);
		return packageBookingRepository.save(packageBooking);
	}

	/**
	 * to get all packagebooking from database
	 * 
	 * @return list of all packagebooking from database.
	 */
	public List<PackageBooking> getAllPackageBookings() {
		return packageBookingRepository.findAll();
	}

	/**
	 * to update packagebooking in database
	 * 
	 * @param packageBooking of PackageBooking type
	 * @return updated PackageBooking
	 */
	public PackageBooking updatePackageBooking(PackageBooking packageBooking) {
		return packageBookingRepository.save(packageBooking);
	}

	/**
	 * to delete packagebooking from database
	 * 
	 * @param id of int type
	 * @return message after deletion
	 */
	public String deletePackageBookingById(int id) {
		PackageBooking packageBooking = packageBookingRepository.findById(id).orElseThrow(NullPointerException::new);
		packageBookingRepository.deleteById(packageBooking.getId());
		return "PackageBooking with id: " + id + " deleted!!";
	}

	/**
	 * to get pacakagebooking based on id
	 * 
	 * @param id of int type
	 * @return packagebooking whose id matches
	 */
	public PackageBooking getPackageBookingById(int id) {
		return packageBookingRepository.findById(id).orElseThrow(NullPointerException::new);
	}

	/**
	 * to get all packagebooking based on customer's id
	 * 
	 * @param id of int type
	 * @return list of packagebookings whose customer's id matches
	 */
	public List<PackageBooking> getAllPackageBookingsByCustomerId(int id) {
		return packageBookingRepository.findAllByCustomerId(id);
	}

	/**
	 * to get all packagebooking based on booking date
	 * 
	 * @param bookingDate of LocalDate
	 * @return list of packagebookings whose bookingdate matches
	 */
	public List<PackageBooking> getAllPackageBookingByBookingDate(LocalDate bookingDate) {
		return packageBookingRepository.findByBookingDate(bookingDate);
	}
}
