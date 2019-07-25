package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.repository.PackageInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageInformationController {

    @Autowired
    private PackageInformationRepository packageInformationRepository;


}
