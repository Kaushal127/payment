package com.example.payment.services;

import com.example.payment.PaymentGateways.PaymentGatewayFactory;
import com.example.payment.PaymentGateways.PaymentGatewayInterface;
import com.example.payment.PaymentGateways.RazorpayPaymentGateway;
import com.example.payment.models.Payment;
import com.example.payment.models.PaymentGateway;
import com.example.payment.models.PaymentStatus;
import com.example.payment.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGatewayFactory paymentGatewayFactory ;
    private PaymentRepository paymentRepository ;
    public PaymentService (PaymentGatewayFactory paymentGatewayFactory ,PaymentRepository paymentRepository){
        this.paymentGatewayFactory = paymentGatewayFactory ;
        this.paymentRepository = paymentRepository ;
    }
    public String createPaymentLink(Long orderId){
        //I need to get the details of the order
        //  specifically amount

        // Order order =  restTemplate.getForObject("",Order.class) ;
        // Long amount = order.getAmount() ;
        // String userName = order.getUser().getName();
        // String userMobile = order.getUser().getPhoneNumber();
        // String userEmail = order.getUser().getEmail();

        Long amount = 1000L ;
        String userName = "Kaushal" ;
        String userMobile = "9876543210" ;
        String userEmail = "kkk@example.com" ;

        PaymentGatewayInterface paymentGateway = paymentGatewayFactory.getBestPaymentGateway() ;
        String paymentLink = paymentGateway.createPaymentLink(amount,userName,userEmail,userMobile,orderId);

        Payment payment = new Payment();
        payment.setPaymentLink(paymentLink);
        payment.setOrderId(orderId);
        payment.setPaymentGateway(PaymentGateway.RAZORPAY);
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setAmount(amount);

        paymentRepository.save(payment);
        return paymentLink;
    }

    public PaymentStatus getPaymentStatus(String paymentGatewayPaymentId){

        Payment payment = paymentRepository.findByPaymentGatewayReferenceId(paymentGatewayPaymentId);
        PaymentGatewayInterface paymentGateway = null ;
        if(payment.getPaymentGateway().equals(PaymentGateway.RAZORPAY) ){
            paymentGateway = paymentGatewayFactory.getBestPaymentGateway();
        }

        PaymentStatus paymentStatus = paymentGateway.getPaymentStatus(paymentGatewayPaymentId) ;
        payment.setPaymentStatus(paymentStatus);
        paymentRepository.save(payment);
        return paymentStatus ;
    }
}
