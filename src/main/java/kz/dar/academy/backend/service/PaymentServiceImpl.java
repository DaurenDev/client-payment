package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.PaymentRequest;
import kz.dar.academy.backend.model.PaymentResponse;
import kz.dar.academy.backend.repository.PaymentEntity;
import kz.dar.academy.backend.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository repository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) {
        paymentRequest.setPaymentId(UUID.randomUUID().toString());

        PaymentEntity paymentEntity = modelMapper.map(paymentRequest, PaymentEntity.class);
        paymentEntity = repository.save(paymentEntity);

        return modelMapper.map(paymentEntity, PaymentResponse.class);
    }

    @Override
    public PaymentResponse getPaymentById(String paymentId) {
        PaymentEntity paymentEntity = repository.getPaymentEntityByPaymentId(paymentId);
        return modelMapper.map(paymentEntity, PaymentResponse.class);
    }

    @Override
    public PaymentResponse updatePayment(PaymentRequest paymentRequest) {
        PaymentEntity paymentEntity = modelMapper.map(paymentRequest, PaymentEntity.class);

        PaymentEntity dbEntity = repository.getPaymentEntityByPaymentId(paymentRequest.getPaymentId());
        dbEntity.setPaymentId(dbEntity.getPaymentId());

        paymentEntity = repository.save(paymentEntity);

        return modelMapper.map(paymentEntity, PaymentResponse.class);
    }

    @Override
    public void deletePaymentById(String paymentId){
        repository.deletePaymentEntityByPaymentId(paymentId);
    }

    @Override
    public Page<PaymentResponse> getPaymentByClientId(String clientId, Pageable pageable) {
        return repository.getPaymentEntitiesByClientId(clientId, pageable)
                .map(payment -> modelMapper.map(payment, PaymentResponse.class));
    }

    @Override
    public Page<PaymentResponse> getPaymentByOrganizationId(String organizationId, Pageable pageable) {
        return repository.getPaymentEntitiesByOrganizationId(organizationId, pageable)
                .map(payment -> modelMapper.map(payment, PaymentResponse.class));
    }

    @Override
    public Page<PaymentResponse> getPaymentByPaymentType(String paymentType, Pageable pageable) {
        return repository.getPaymentEntitiesByPaymentType(paymentType, pageable)
                .map(payment -> modelMapper.map(payment, PaymentResponse.class));
    }
}
