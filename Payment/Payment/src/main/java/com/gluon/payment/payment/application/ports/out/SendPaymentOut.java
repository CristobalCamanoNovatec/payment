package com.gluon.payment.payment.application.ports.out;

import com.gluon.payment.payment.domain.exception.BusinessException;
import com.gluon.payment.payment.domain.gluon.GluonRequest;
import com.gluon.payment.payment.domain.gluon.GluonResponse;

public interface SendPaymentOut {

    public Boolean sendPayment(GluonRequest gluon) throws BusinessException;

}
