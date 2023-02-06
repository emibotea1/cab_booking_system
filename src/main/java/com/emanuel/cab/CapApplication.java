package com.emanuel.cab;

import com.emanuel.cab.model.Driver;
import com.emanuel.cab.service.IDriverService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapApplication implements CommandLineRunner {

    private final IDriverService iDriverService;

    public CapApplication(IDriverService iDriverService) {
        this.iDriverService = iDriverService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CapApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Driver driver = new Driver();
        driver.setName("Tudor Mihaescu");
        driver.setPhoneNumber("0798007041");
        driver.setAvailable(false);
        driver.setRating(setDriverRating(3.9));
        driver.setLatitude("45.647269720061836");
        driver.setLongitude("25.59872413228321");

        iDriverService.save(driver);
    }

    private double setDriverRating(double rating) {
        if (rating >= 1 && rating <= 5) {
            System.out.println("-------- Rating IS within the legal parameters. --------");
            return rating;
        } else {
            System.out.println("-------- Rating IS NOT within the legal parameters. --------");
            return 0.0;
        }
    }
}

