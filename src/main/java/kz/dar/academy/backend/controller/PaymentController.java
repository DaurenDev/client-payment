package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.model.PaymentRequest;
import kz.dar.academy.backend.model.PaymentResponse;
import kz.dar.academy.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest){
        return paymentService.createPayment(paymentRequest);
    }

    @GetMapping
    public PaymentResponse getPaymentById(@RequestParam String paymentId){
        return paymentService.getPaymentById(paymentId);
    }

    @PutMapping
    public PaymentResponse updatePayment(@RequestParam String paymentId, PaymentRequest paymentRequest){
        paymentRequest.setPaymentId(paymentId);
        return paymentService.updatePayment(paymentRequest);
    }

    @DeleteMapping
    public void deletePayment(@RequestParam String paymentId){
        paymentService.deletePaymentById(paymentId);
    }

    @GetMapping("/client")
    public Page<PaymentResponse> getPaymentByClient(@RequestParam String clientId, Pageable pageable) {
        return paymentService.getPaymentByClientId(clientId, pageable);
    }

    @GetMapping("/organization")
    public Page<PaymentResponse> getPaymentByOrganization(@RequestParam String organizationId, Pageable pageable) {
        return paymentService.getPaymentByOrganizationId(organizationId, pageable);
    }

    @GetMapping("/type")
    public Page<PaymentResponse> getPaymentByType(@RequestParam String paymentType, Pageable pageable) {
        return paymentService.getPaymentByPaymentType(paymentType, pageable);
    }

}
