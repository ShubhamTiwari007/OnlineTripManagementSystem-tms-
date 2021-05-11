package com.cg.tms.services;

import java.util.List;

import com.cg.tms.entities.Package;

public interface IPackageService {

	public Package addPackage(Package pack);

	public List<Package> getAllPackage();

	public Package updatePackage(Package pack);

	public String delete(int id);

	public Package getPackageById(int id);

}