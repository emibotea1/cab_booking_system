package com.emanuel.cab.dto;


import com.emanuel.cab.model.Userr;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDto {

    private Integer id;
    @NotNull
    @NotEmpty
    private String pickUpLocation;
    @NotEmpty
    @NotNull
    private String dropOffPoint;
    private Long createdAt;
    private Userr userid;
}
