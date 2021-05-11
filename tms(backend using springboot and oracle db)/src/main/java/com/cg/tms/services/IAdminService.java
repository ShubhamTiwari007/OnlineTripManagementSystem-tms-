package com.cg.tms.services;

import com.cg.tms.entities.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin);

	public boolean isValidAdmin(String username, String password);
}