package com.oocl.packagebooking.service.impl;

import com.oocl.packagebooking.model.PackageInformation;
import com.oocl.packagebooking.repository.PackageInformationRepository;
import com.oocl.packagebooking.service.PackageInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageInformationServiceImpl implements PackageInformationService {
    @Autowired
    private PackageInformationRepository packageInformationRepository;

    @Override
    public PackageInformation updatePackageInformation(long id,PackageInformation packageInformation) {
        PackageInformation information1 = packageInformationRepository.findById(id).orElse(null);
        if (information1 != null) {
            packageInformation.setId(id);
            PackageInformation information = packageInformationRepository.save(packageInformation);
            return information;
        }else {
            return null;
        }
    }

    @Override
    public PackageInformation addPackageInformation(PackageInformation packageInformation) {
        return packageInformationRepository.save(packageInformation);
    }

    @Override
    public List<PackageInformation> getAllPackageInformationByStatus(int state) {
        return packageInformationRepository.findAllByState(state);
    }

    @Override
    public List<PackageInformation> getAllPackageInformation() {
        return packageInformationRepository.findAll();
    }

}
