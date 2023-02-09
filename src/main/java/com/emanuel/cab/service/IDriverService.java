package com.emanuel.cab.service;

import com.emanuel.cab.dto.DriverDto;
import com.emanuel.cab.model.Driver;

public interface IDriverService {

    Driver saveDriver(DriverDto driverDto);
}
