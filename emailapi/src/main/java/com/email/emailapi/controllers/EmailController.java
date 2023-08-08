package com.email.emailapi.controllers;

import com.email.emailapi.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/mail")
    public String sendMail(@RequestParam String toEmail,
                           @RequestParam String subject,
                           @RequestParam String body)
    {
        return emailService.sendMail(toEmail,subject,body);
    }
}
