package com.oocl.packagebooking.service;

import com.oocl.packagebooking.model.PackageInformation;
import com.oocl.packagebooking.repository.PackageInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface PackageInformationService {
    PackageInformation updatePackageInformation(long id,PackageInformation packageInformation);
    PackageInformation addPackageInformation(PackageInformation packageInformation);
    List<PackageInformation> getAllPackageInformationByStatus(int state);
    List<PackageInformation> getAllPackageInformation();

}
