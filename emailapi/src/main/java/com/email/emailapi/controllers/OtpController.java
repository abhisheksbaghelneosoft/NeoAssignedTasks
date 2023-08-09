package com.email.emailapi.controllers;


import com.email.emailapi.dtos.OtpRequestDto;
import com.email.emailapi.dtos.OtpValidateRequest;
import com.email.emailapi.repository.CacheRepository;
import com.email.emailapi.services.EmailService;
import com.email.emailapi.utils.OtpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/send/otp")
public class OtpController {

    private final CacheRepository cacheRepository;
    private final OtpGenerator otpGenerator;
    @Autowired
    private EmailService emailService;

    public static final String SUBJECT= "Otp For Resetting Your DbAdmin Account's Password";

    @Autowired
    public OtpController(CacheRepository cacheRepository, OtpGenerator otpGenerator) {
        this.cacheRepository = cacheRepository;
        this.otpGenerator = otpGenerator;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> addToCache(@RequestBody OtpRequestDto key) {

        String value = String.valueOf(otpGenerator.generateOtp());
        cacheRepository.put(key.getEmail(), Integer.valueOf(value));
        emailService.sendMail(key.getEmail(),SUBJECT,value);

        return ResponseEntity.ok("Otp Generated Successfully Otp : " + value);
    }


    @PostMapping("/verify")
    public ResponseEntity<String> removeFromCache(@RequestBody OtpValidateRequest otpValidateRequest) {

        Optional<String> s = cacheRepository.get(otpValidateRequest.getKey());

        if (s.isPresent() && s.get().equals(otpValidateRequest.getOtp())) {
            cacheRepository.remove(otpValidateRequest.getKey());
            return ResponseEntity.ok("Key Removed from cache key:  " + otpValidateRequest.getKey());
        }

        return ResponseEntity.badRequest().body("Invalid Otp");
    }

}
