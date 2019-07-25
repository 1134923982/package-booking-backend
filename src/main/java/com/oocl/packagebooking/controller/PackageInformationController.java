package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.PackageInformation;
import com.oocl.packagebooking.repository.PackageInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PackageInformationController {

    @Autowired
    private PackageInformationRepository packageInformationRepository;

    @GetMapping("/package-informations")
    public ResponseEntity getAllPackageInformation() {
        List<PackageInformation> allPackageInformation = packageInformationRepository.findAll();
        return ResponseEntity.ok(allPackageInformation);
    }

    @PostMapping("/package-informations")
    public ResponseEntity addPackageInformation(@RequestBody PackageInformation packageInformation) {
//        packageInformation.setBookingTime(new Date());
        PackageInformation information = packageInformationRepository.save(packageInformation);
        return ResponseEntity.ok(information);
    }

    @PutMapping("/package-informations/{id}")
    public ResponseEntity updatePackageInformation(@PathVariable long id, @RequestBody PackageInformation packageInformation) {
        PackageInformation information1 = packageInformationRepository.findById(id).orElse(null);
        if (information1 != null) {
            packageInformation.setId(id);
            PackageInformation information = packageInformationRepository.save(packageInformation);
            return ResponseEntity.ok(information);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/package-informations/{state}")
    public ResponseEntity getAllPackageInformationByStatus(@PathVariable int state) {
        List<PackageInformation> packages = packageInformationRepository.findAllByState(state);
        return ResponseEntity.ok(packages);
    }


}
