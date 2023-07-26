package com.example.authsample.wrapper;

import com.example.authsample.common.wrapper.ReferenceBaseWrapper;

public class UserRoleWrapper extends ReferenceBaseWrapper {

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
