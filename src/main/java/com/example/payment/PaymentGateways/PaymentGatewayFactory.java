package com.example.payment.PaymentGateways;

//import com.razorpay.RazorpayClient;
//
//import java.util.Random;

import com.razorpay.RazorpayClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayFactory {
    private RazorpayPaymentGateway razorpayPaymentGateway ;
    public PaymentGatewayFactory(RazorpayPaymentGateway razorpayPaymentGateway){
        this.razorpayPaymentGateway=razorpayPaymentGateway;
    }
    public PaymentGatewayInterface getBestPaymentGateway(){
//        int random = new Random().nextInt() ;
//        if(random%2==0){
//            return new RazorpayPaymentGateway();
//        }
//        return new StripePaymentGateway();
        return razorpayPaymentGateway;
    }
}
