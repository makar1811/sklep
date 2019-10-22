package pl.training.cloud.shop.payments.payments.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.cloud.shop.payments.payments.dto.PaymentsDto;
import pl.training.cloud.shop.payments.payments.model.Payments;
import pl.training.cloud.shop.payments.payments.model.Mapper;
import pl.training.cloud.shop.payments.payments.service.PaymentsService;


import java.net.URI;

@RequestMapping("payments")
@RestController
@RequiredArgsConstructor
public class PaymentsController {


    @NonNull
    private PaymentsService paymentsService;

    @NonNull
    private Mapper mapper;
    private UriBuilder uriBuilder = new UriBuilder();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createPayment(@RequestBody PaymentsDto paymentsDto) {
        Payments payments = paymentsService.addPayment(dtoToModel(paymentsDto));
        URI newDepartmentUri = uriBuilder.requestUriWithId(payments.getPaymentId());
        return ResponseEntity.created(newDepartmentUri).body(modelToDto(payments));
    }

    private PaymentsDto modelToDto(Payments payments) {
        return mapper.map(payments, PaymentsDto.class);
    }

    private Payments dtoToModel(PaymentsDto paymentsDto) {
        return mapper.map(paymentsDto, Payments.class);
    }

}
