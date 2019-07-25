package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.model.PackageInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PackageInformationRepository extends JpaRepository<PackageInformation,Long> {
}
