package com.example.moviespringauth.Service.Interface;

import com.example.moviespringauth.Entities.Payment;

import java.util.List;

public interface PaymentService {
    Payment savePayment(Payment payment);
    List<Payment> savePayments(List<Payment> payments);
    List<Payment> getPayments();
    String deletePayment(Long paymentId);
    Payment updatePayment(Payment payment);
    Payment getPaymentByAmount(int amount);
//    Payment getPaymentByCustomer();
//    Payment getPaymentByRental();
//    Payment getPaymentByStaff();
}