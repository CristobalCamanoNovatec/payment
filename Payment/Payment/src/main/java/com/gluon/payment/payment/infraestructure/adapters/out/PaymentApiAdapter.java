package com.gluon.payment.payment.infraestructure.adapters.out;

import com.gluon.payment.payment.application.ports.out.SendPaymentOut;
import com.gluon.payment.payment.domain.exception.BusinessException;
import com.gluon.payment.payment.domain.gluon.GluonRequest;
import com.gluon.payment.payment.domain.gluon.GluonResponse;
import com.gluon.payment.payment.infraestructure.adapters.out.dto.altair.Altair;
import com.gluon.payment.payment.infraestructure.adapters.out.dto.altair.AltairMapper;
import com.gluon.payment.payment.util.EnviromentGlobal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PaymentApiAdapter implements SendPaymentOut {

    //@Value("${url_api}")
    private String urlApi;

    private final WebClient webClient;

    public PaymentApiAdapter(WebClient webClient){
        this.webClient = webClient;
    }

    @Override
    public Boolean sendPayment(GluonRequest gluon) throws BusinessException {

        Altair altair = null;
        try {
            altair = AltairMapper.GluonRequestToAltair(gluon);

        } catch (Exception e){
            throw new BusinessException(EnviromentGlobal.MESSAGE_ERROR_DATA_);
        }

        try {

        webClient.post()
                .uri(urlApi)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(altair)
                .retrieve()
                .bodyToMono(GluonResponse.class)
                .subscribe(
                        response -> {
                            System.out.println("Manejo de la peticion exitosa");
                        },
                        error -> {
                            System.out.println("Manejo de la peticion con error");
                        }
                );
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return true;
    }

}
