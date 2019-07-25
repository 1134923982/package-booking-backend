package com.oocl.packagebooking.controller;

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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PackageInformationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PackageInformationService mockPackageInformationService;

    private List<PackageInformation> packageInformations = new ArrayList<>();
    @Before
    public void setUp() throws Exception {

        packageInformations.add(new PackageInformation(1,"张三","12345",0,null));
        packageInformations.add(new PackageInformation(2,"王五","123454",0,null));
    }

    @Test
    public void should_return_all_package_information_when_request_all_packages() throws Exception {
        Mockito.when(
                mockPackageInformationService.getAllPackageInformation()
        ).thenReturn(packageInformations);

        mockMvc.perform(get("/package-informations"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"username\":\"张三\",\"iphoneNumber\":\"12345\",\"state\":0,\"bookingTime\":null},{\"id\":2,\"username\":\"王五\",\"iphoneNumber\":\"123454\",\"state\":0,\"bookingTime\":null}]"));
    }

    @Test
    public void should_return_add_package_information_when_add_package_to_store() throws Exception {
        PackageInformation packageInformation = new PackageInformation(2, "王五", "123454", 0, null);
        Mockito.when(
                mockPackageInformationService.addPackageInformation(Mockito.any())
        ).thenReturn(packageInformation);

        mockMvc.perform(post("/package-informations").contentType(MediaType.APPLICATION_JSON_UTF8).content("{}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"username\":\"王五\",\"iphoneNumber\":\"123454\",\"state\":0,\"bookingTime\":null}"));
    }

    @Test
    public void should_return_all_package_information_by_state_when_get_packages_by_state() throws Exception {
        Mockito.when(
                mockPackageInformationService.getAllPackageInformationByStatus(Mockito.anyInt())
        ).thenReturn(packageInformations);

        mockMvc.perform(get("/package-informations/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"username\":\"张三\",\"iphoneNumber\":\"12345\",\"state\":0,\"bookingTime\":null},{\"id\":2,\"username\":\"王五\",\"iphoneNumber\":\"123454\",\"state\":0,\"bookingTime\":null}]"));
    }

}