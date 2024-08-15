package com.gluon.payment.payment.application.ports.in;

import com.gluon.payment.payment.domain.exception.BusinessException;
import com.gluon.payment.payment.domain.gluon.GluonRequest;
import com.gluon.payment.payment.domain.gluon.GluonResponse;

public interface SendPaymentIn {

    public String sendPayment(GluonRequest gluon) throws BusinessException;

}
