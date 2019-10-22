package pl.training.cloud.shop.payments.payments.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Payments {

    @NonNull
    private Long paymentId;
    @NonNull
    private double amount;
}
