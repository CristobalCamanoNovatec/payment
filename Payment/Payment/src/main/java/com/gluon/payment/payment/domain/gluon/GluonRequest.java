package com.gluon.payment.payment.domain.gluon;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dto que almacenara los datos de la respuesta")
public class GluonRequest {

    @Schema(description = "Campo utilizado para el id")
    private Long id;
    private String transaction;

    public GluonRequest(Long id, String transaction) {
        this.id = id;
        this.transaction = transaction;
    }

    public GluonRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
}
