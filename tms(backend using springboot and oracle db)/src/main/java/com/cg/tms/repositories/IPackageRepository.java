package com.cg.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Package;

public interface IPackageRepository extends JpaRepository<Package, Integer> {

	public Package findPackageById(int id);

}