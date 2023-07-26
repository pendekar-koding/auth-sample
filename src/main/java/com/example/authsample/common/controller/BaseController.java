package com.example.authsample.common.controller;

public class BaseController {
    protected static final String STR_SUCCESS = "success";
    protected static final String STR_FAILED = "failed";
    protected static final String STR_ERROR = "error";
    protected static final String STR_CREATED_BY = "SYSTEM";

    protected static final String partnerServiceId = "partnerServiceId";
    protected static final String customerNo = "customerNo";
    protected static final String virtualAccountNo = "virtualAccountNo";
    protected static final String inquiryRequestId = "inquiryRequestId";
    protected static final String paymentRequestId = "paymentRequestId";
    protected static final String CHANNEL_ID = "CHANNEL-ID";
    protected static final String X_PARTNER_ID = "X-PARTNER-ID";
    protected static final String valueTotal = "value";
    protected static final String currencyTotal = "currency";
    protected static final String paidAmount = "paidAmount";


    @Override
    public String toString() {
        return "BaseController{}";
    }
}
