package com.cg.tms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Package;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.repositories.IPackageRepository;

/**
 * 
 * Class to implement CRUD operations from IPackageRepository
 * 
 */
@Service
public class PackageServiceImpl implements IPackageService {

	@Autowired
	private IPackageRepository packageRepository;

	/**
	 * 
	 * @param pack of Package type
	 */
	public Package addPackage(Package pack) {
		return packageRepository.save(pack);
	}

	/**
	 * 
	 * @return list of all packages
	 */
	public List<Package> getAllPackage() {
		return packageRepository.findAll();
	}

	/**
	 * to Update Package in Database
	 * 
	 * @param pack of Pakcage type
	 * @return updated Package
	 */
	public Package updatePackage(Package pack) {
		return packageRepository.save(pack);
	}

	/**
	 * 
	 * @param id of integer type
	 */
	public String delete(int id) {
		Package pack = packageRepository.findById(id).orElseThrow(
				() -> new PackageNotFoundException("Cannot delete,No package with id: " + id + " found!!"));
		packageRepository.deleteById(pack.getId());
		return "Package with id: " + pack.getId() + " deleted!!";
	}

	/**
	 * 
	 * @param id of integer type
	 * @return Package whose id matches
	 */
	public Package getPackageById(int id) {
		return packageRepository.findById(id)
				.orElseThrow(() -> new PackageNotFoundException("No cusotmer with id: " + id + " found!!"));
	}

}