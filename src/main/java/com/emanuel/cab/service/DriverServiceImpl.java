package com.emanuel.cab.service;

import com.emanuel.cab.model.Driver;
import com.emanuel.cab.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements IDriverService {

    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void save(Driver driver) {
        driver.setName(driver.getName());
        driver.setPhoneNumber(driver.getPhoneNumber());
        driver.setRating(driver.getRating());
        driver.setAvailable(driver.getAvailable());
        driver.setLatitude(driver.getLatitude());
        driver.setLongitude(driver.getLongitude());

        driverRepository.save(driver);

    }
}
