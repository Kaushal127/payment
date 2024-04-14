package com.example.payment.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private Long amount ;
    private PaymentStatus paymentStatus ;
    private Long userId ;
    private Long orderId ;
    private String paymentLink ;
    private String paymentGatewayReferenceId ;
    private PaymentGateway paymentGateway ;
}
