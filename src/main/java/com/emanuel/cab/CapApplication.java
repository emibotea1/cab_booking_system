package com.emanuel.cab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository repository, PasswordEncoder passwordEncoder) {
//        return args -> {
//            repository.save(new User("Emanuel"
//                    , "Botea"
//                    , "emanuelbotea@yahoo.com"
//                    , "0748531443"
//                    , "emilian"
//                    , passwordEncoder.encode("password")
//                    , UserRole.USER));
//        };
    }

