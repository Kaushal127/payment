package com.example.payment.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhooks/razorpay")
public class RazorPayWebhookController {
    @PostMapping
    public void handleWebhookEvent(){
        System.out.println("Hi");
    }
}
