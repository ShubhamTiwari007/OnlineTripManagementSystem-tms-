package com.cg.tms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.tms.entities.Admin;
import com.cg.tms.repositories.IAdminRepository;

/**
 * 
 * Class to implement CRUD operations from IHotleRepository
 * 
 */
@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository adminRepository;

	/**
	 * 
	 * @param admin of Admin type
	 */
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	/**
	 * to Validate Admin
	 * 
	 * @param username
	 * @param password
	 * @return true if username and password is correct
	 */
	public boolean isValidAdmin(String username, String password) {
		return adminRepository.findByUsernameAndPassword(username, password) != null;
	}

}
