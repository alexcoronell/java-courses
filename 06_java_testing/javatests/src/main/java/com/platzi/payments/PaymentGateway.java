package com.platzi.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}
