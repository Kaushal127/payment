package com.example.payment.PaymentGateways;

//import com.razorpay.RazorpayClient;
//
//import java.util.Random;

import com.razorpay.RazorpayClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayFactory {
    private StripePaymentGateway stripePaymentGateway ;
    public PaymentGatewayFactory(StripePaymentGateway stripePaymentGateway){
        this.stripePaymentGateway=stripePaymentGateway;
    }
    public PaymentGatewayInterface getBestPaymentGateway(){
//        int random = new Random().nextInt() ;
//        if(random%2==0){
//            return new RazorpayPaymentGateway();
//        }
//        return new StripePaymentGateway();
        return stripePaymentGateway;
    }
}
