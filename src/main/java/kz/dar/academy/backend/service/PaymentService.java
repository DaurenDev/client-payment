package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.PaymentRequest;
import kz.dar.academy.backend.model.PaymentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService {
    PaymentResponse createPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentById(String paymentId);

    PaymentResponse updatePayment(PaymentRequest paymentRequest);

    void deletePaymentById(String paymentId);

    Page<PaymentResponse> getPaymentByClientId(String clientId, Pageable pageable);

    Page<PaymentResponse> getPaymentByOrganizationId(String organizationId, Pageable pageable);

    Page<PaymentResponse> getPaymentByPaymentType(String paymentType, Pageable pageable);
}
