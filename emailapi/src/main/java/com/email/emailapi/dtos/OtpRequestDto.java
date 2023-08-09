package com.email.emailapi.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class OtpRequestDto implements Serializable {

    private String email;
}