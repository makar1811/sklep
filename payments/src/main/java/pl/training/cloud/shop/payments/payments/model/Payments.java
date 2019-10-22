package pl.training.cloud.shop.payments.payments.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payments {

    @Id
    String paymentId;
    @NonNull
    double amount;
}
