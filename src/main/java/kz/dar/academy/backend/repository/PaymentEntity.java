package kz.dar.academy.backend.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "client-payment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentEntity {
    @Id
    @Field(type = FieldType.Keyword)
    private String paymentId;
    @Field(type = FieldType.Keyword)
    private String clientId;
    @Field(type = FieldType.Keyword)
    private String organizationId;
    @Field(type = FieldType.Text)
    private String paymentType;
    @Field(type = FieldType.Text)
    private String paymentDescription;
}
