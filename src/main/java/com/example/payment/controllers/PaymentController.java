package com.example.payment.controllers;

import com.example.payment.dtos.CreatePaymentLinkRequestDto;
import com.example.payment.dtos.CreatePaymentLinkResponseDto;
import com.example.payment.models.Payment;
import com.example.payment.models.PaymentStatus;
import com.example.payment.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments/")
public class PaymentController {
    private PaymentService paymentService ;
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService ;
    }


    @PostMapping()
    public CreatePaymentLinkResponseDto createPaymentLink(@RequestBody CreatePaymentLinkRequestDto request) {
        String redirectUrl = this.paymentService.createPaymentLink(request.getOrderId());
        CreatePaymentLinkResponseDto response = new CreatePaymentLinkResponseDto() ;
        response.setUrl(redirectUrl);
        return response ;
    }
    @GetMapping("/{id}")
    public PaymentStatus checkPaymentStatus(@PathVariable("id") String paymentGatewayPaymentId){
        return this.paymentService.getPaymentStatus(paymentGatewayPaymentId) ;
    }

}


// User - createOrder() ---> OrderService
// User - createPaymentLink()--> PaymentService
// User(Order Details Page) -> CheckPaymentStatus() -> PaymentService
// PaymentGateway (webhook) -> PaymentService