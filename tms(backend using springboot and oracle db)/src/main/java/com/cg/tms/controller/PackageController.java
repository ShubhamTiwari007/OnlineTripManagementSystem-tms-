package com.cg.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entities.Package;
import com.cg.tms.services.IPackageService;

/**
 * 
 * Controller class for testing PackageServiceImpl
 *
 */
@RestController
@CrossOrigin("*")
public class PackageController {

	@Autowired
	private IPackageService packageService;

	@PostMapping("/addpackage")
	public ResponseEntity<Package> addPackage(@RequestBody Package pack) {
		return new ResponseEntity<Package>(packageService.addPackage(pack), HttpStatus.OK);
	}

	@GetMapping("/getpackages")
	public List<Package> getAllPackages() {
		return packageService.getAllPackage();
	}
	
	@PutMapping("/updatepackage") 
	public ResponseEntity<Package> updateHotel(@RequestBody Package pack) {
		return new ResponseEntity<>(packageService.updatePackage(pack), HttpStatus.OK);
	}

	@DeleteMapping("/deletepackagebyid/{id}")
	public String deletePackage(@PathVariable int id) {
		return packageService.delete(id);
	}
	
	@GetMapping("/getpackagebyid/{id}")
	public ResponseEntity<Package> getPackageById(@PathVariable int id) {
		Package pack = packageService.getPackageById(id);
		return new ResponseEntity<>(pack, HttpStatus.OK);
	}

}