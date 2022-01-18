package com.cbua.gateway.controllers;

import lombok.Data;

@Data
public class AddressDto {
    private String addressOne;
    private String addressTwo;
    private String city;
    private Integer zip;
    private String country;
}
