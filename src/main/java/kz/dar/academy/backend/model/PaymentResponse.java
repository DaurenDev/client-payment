package kz.dar.academy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentResponse {
    private String paymentId;
    private String clientId;
    private String organizationId;
    private String paymentType;
    private String paymentDescription;
}
