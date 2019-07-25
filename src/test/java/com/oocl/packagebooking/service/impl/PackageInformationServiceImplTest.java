package com.oocl.packagebooking.service.impl;

import com.oocl.packagebooking.model.PackageInformation;
import com.oocl.packagebooking.repository.PackageInformationRepository;
import com.oocl.packagebooking.service.PackageInformationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PackageInformationServiceImplTest {

    @MockBean
    private PackageInformationRepository mockPackageInformationRepository;
    @Autowired
    private PackageInformationService packageInformationService;

    private List<PackageInformation> packageInformations = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void should_return_null_when_update_a_error_package_by_id() throws Exception {
        Mockito.when(
                mockPackageInformationRepository.findById(Mockito.anyLong())
        ).thenReturn(Optional.empty());
        new PackageInformation();
        PackageInformation information = packageInformationService.updatePackageInformation(1,  new PackageInformation());
        assertNull(information);
    }

    @Test
    public void should_return_package_when_update_a_right_package_by_id() throws Exception {
        PackageInformation information = new PackageInformation(1, "张三", "12345", 0, null);
        Mockito.when(
                mockPackageInformationRepository.findById(Mockito.anyLong())
        ).thenReturn(Optional.of(information));
        Mockito.when(
                mockPackageInformationRepository.save(Mockito.any())
        ).thenReturn(information);
        PackageInformation updateInformation = packageInformationService.updatePackageInformation(1,  information);
        assertEquals(information,updateInformation);
    }
}