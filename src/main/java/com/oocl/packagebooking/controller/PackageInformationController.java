package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.PackageInformation;
import com.oocl.packagebooking.repository.PackageInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3001")
public class PackageInformationController {

    @Autowired
    private PackageInformationRepository packageInformationRepository;

    @GetMapping("/package-informations")
    public ResponseEntity getAllPackageInformation(){
        List<PackageInformation> allPackageInformation = packageInformationRepository.findAll();
        return ResponseEntity.ok(allPackageInformation);
    }

    @PostMapping("/package-informations")
    public ResponseEntity addPackageInformation(@RequestBody PackageInformation packageInformation){
//        packageInformation.setBookingTime(new Date());
        PackageInformation information = packageInformationRepository.save(packageInformation);
        return ResponseEntity.ok(information);
    }




}
