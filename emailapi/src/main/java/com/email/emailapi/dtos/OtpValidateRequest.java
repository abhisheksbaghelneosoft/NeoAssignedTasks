package com.email.emailapi.dtos;

import lombok.Data;

@Data
public class OtpValidateRequest {

    private String key;
    private String otp;

}
