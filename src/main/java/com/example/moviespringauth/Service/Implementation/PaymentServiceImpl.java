package com.example.moviespringauth.Service.Implementation;

import com.example.moviespringauth.Entities.Payment;
import com.example.moviespringauth.Repositories.PaymentRepository;
import com.example.moviespringauth.Service.Interface.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment savePayment(Payment payment) {
        log.info("Saving new payment {} to the database", payment.getAmount());
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> savePayments(List<Payment> payments) {
        log.info("Saving new payments to the database");
        return paymentRepository.saveAll(payments);
    }

    @Override
    public List<Payment> getPayments() {
        log.info("Fetching all payments");
        return paymentRepository.findAll();
    }

    @Override
    public String deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
        return "Payment has been removed!!" +paymentId;
    }

    @Override
    public Payment updatePayment(Payment payment) {
        Payment existingPayment = paymentRepository.findById(payment.getPaymentId()).orElse(null);
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setCustomer1(payment.getCustomer1());
        existingPayment.setRental1(payment.getRental1());
        existingPayment.setStaff1(payment.getStaff1());
        existingPayment.setPaymentDate(payment.getPaymentDate());
        return paymentRepository.save(existingPayment);
    }

    @Override
    public Payment getPaymentByAmount(int amount) {
        return paymentRepository.findByAmount(amount);
    }

//    @Override
//    public Payment getPaymentByCustomer() {
//        return null;
//    }

//    @Override
//    public Payment getPaymentByRental() {
//        return null;
//    }

//    @Override
//    public Payment getPaymentByStaff() {
//        return null;
//    }
}