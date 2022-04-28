package kz.dar.academy.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends ElasticsearchRepository<PaymentEntity, String> {
    PaymentEntity deletePaymentEntityByPaymentId(String paymentId);

    PaymentEntity getPaymentEntityByPaymentId(String paymentId);

    Page<PaymentEntity> getPaymentEntitiesByClientId(String clientId, Pageable pageable);

    Page<PaymentEntity> getPaymentEntitiesByOrganizationId(String organizationId, Pageable pageable);

    Page<PaymentEntity> getPaymentEntitiesByPaymentType(String paymentType, Pageable pageable);
}
