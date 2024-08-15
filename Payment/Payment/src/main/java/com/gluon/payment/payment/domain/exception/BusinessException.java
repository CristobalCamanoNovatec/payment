package com.gluon.payment.payment.domain.exception;

public class BusinessException extends Exception{

    public BusinessException(String error){
        super(error);
    }

}
