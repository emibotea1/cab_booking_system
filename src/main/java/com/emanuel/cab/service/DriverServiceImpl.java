package com.emanuel.cab.service;

import com.emanuel.cab.dto.DriverDto;
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
    public Driver saveDriver(DriverDto driverDto) {
        Driver driver = new Driver();

        driver.setName(driverDto.getName());
        driver.setPhoneNumber(driverDto.getPhoneNumber());
        driver.setRating(driverDto.getRating());
        driver.setAvailable(driverDto.getAvailable());
        driver.setLongitude(driverDto.getLongitude());
        driver.setLatitude(driverDto.getLatitude());

        driverRepository.save(driver);

        return driver;
    }
}
