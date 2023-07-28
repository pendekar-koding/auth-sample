package com.example.authsample.common.controller;

public class BaseController {
    protected static final String STR_SUCCESS = "success";
    protected static final String STR_FAILED = "failed";
    protected static final String STR_FAILED_LOGIN = "Incorrect username or password";
    protected static final String STR_FAILED_FORBIDDEN = "Forbidden";
    protected static final String STR_ERROR = "error";


    @Override
    public String toString() {
        return "BaseController{}";
    }
}
