package com.example.moviespringauth.controller;

import com.example.moviespringauth.Entities.Customer;
import com.example.moviespringauth.Entities.Payment;
import com.example.moviespringauth.Service.Interface.CustomerService;
import com.example.moviespringauth.Service.Interface.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getPayments() {
        return ResponseEntity.ok().body(paymentService.getPayments());
    }

    @GetMapping("/{amount}")
    public Payment findPaymentByAmount(@PathVariable int amount) {
        return paymentService.getPaymentByAmount(amount) ;
    }

    @PostMapping("/save")
    public ResponseEntity<Payment>savePayment(@RequestBody Payment payment) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/payment/save").toUriString());
        return ResponseEntity.created(uri).body(paymentService.savePayment(payment));
    }

    @PostMapping("/savePayments")
    public List<Payment> addPayments(@RequestBody List<Payment> payments) {
        return paymentService.savePayments(payments);
    }

    @PutMapping("/update")
    public Payment updatePayment(@RequestBody Payment payment) {
        return paymentService.updatePayment(payment);
    }

    @DeleteMapping("/delete/{paymentId}")
    public String deletePayment(@PathVariable Long paymentId) {
        return paymentService.deletePayment(paymentId);
    }

}
