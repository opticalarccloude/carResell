package com.spring.jwt.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BidDetailsDTO {

    private Integer bidCarId;

    private Integer beadingCarId;

    private LocalDateTime Time;

    private LocalDateTime closingTime;

    private LocalDateTime createdAt;


    private Boolean musicFeature;


    private String area;


    private String bodyType;


    private String brand;


    private Boolean carInsurance;


    private String carStatus;


    private String city;


    private String color;


    private String description;


    private String fuelType;


    private int kmDriven;


    private String model;


    private int noOfWheels;


    private int ownerSerial;


    private Boolean powerWindowFeature;


    private int price;


    private Boolean rearParkingCameraFeature;


    private String registration;


    private String safetyDescription;


    private String transmission;


    private String tyre;


    private int year;


    private LocalDate date;


    private int userId;

}
