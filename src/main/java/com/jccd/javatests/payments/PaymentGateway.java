package com.jccd.javatests.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}
