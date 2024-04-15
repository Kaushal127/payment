package com.example.payment.configs;

import com.stripe.StripeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {
    @Value("${stripe_secret_key}")
    private String stripeSecretKey ;

    @Bean
    public StripeClient createStripeClient(){
        return new StripeClient(stripeSecretKey);
    }
}
