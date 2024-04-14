package com.example.payment.PaymentGateways;

import com.example.payment.models.PaymentStatus;

public interface PaymentGatewayInterface {
    String createPaymentLink(
            Long amount,
            String userName ,
            String userEmail,
            String userPhone,
            Long orderId
    ) ;
    PaymentStatus getPaymentStatus(String paymentId) ;

}
