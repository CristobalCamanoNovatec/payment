package com.gluon.payment.payment.infraestructure.adapters.out.dto.altair;

import com.gluon.payment.payment.domain.gluon.GluonRequest;

public class AltairMapper {

    public static final Altair GluonRequestToAltair(GluonRequest response){
        return new Altair();
    }

}
