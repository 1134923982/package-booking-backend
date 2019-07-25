package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.model.PackageInformation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@RunWith(SpringRunner.class)
public class PackageInformationRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PackageInformationRepository packageInformationRepository;

    @Before
    public void setUp() throws Exception {
        entityManager.persist(new PackageInformation(1, "张三", "12345", 0, null));
        entityManager.persist(new PackageInformation(2, "张三", "12345", 1, null));
    }

    @Test
    public void should_return_size_is_1_when_filter_by_package_status() {
        int size = packageInformationRepository.findAllByState(0).size();
        assertEquals(1,size);
    }
}