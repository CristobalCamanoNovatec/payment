package com.gluon.payment.payment.application.services;

import com.gluon.payment.payment.application.ports.in.SendPaymentIn;
import com.gluon.payment.payment.application.ports.out.SendPaymentOut;
import com.gluon.payment.payment.domain.exception.BusinessException;
import com.gluon.payment.payment.domain.gluon.GluonRequest;
import com.gluon.payment.payment.util.EnviromentGlobal;
import org.springframework.stereotype.Service;

@Service
public class SendPaymentUseCase implements SendPaymentIn {

    private final SendPaymentOut sendPaymentOut;

    public SendPaymentUseCase(SendPaymentOut sendPaymentOut){
        this.sendPaymentOut = sendPaymentOut;
    }

    public String sendPayment(GluonRequest gluon) throws BusinessException {
        sendPaymentOut.sendPayment(gluon);
        return EnviromentGlobal.MESSAGE_RESPONSE_PROCESING;
    }

}
