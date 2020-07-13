package com.rootnite.fastdelivery.microwsdms.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClientDto {
    private Long id;
    private String email;
    private String mobileNumber;
    private String completeName;
    private Integer authType;
    private Long authId;
    private Date birthday;
    private Integer genero;
    private String nit;
    private String businessName;
}
