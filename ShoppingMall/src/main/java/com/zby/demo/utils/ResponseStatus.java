package com.zby.demo.utils;

public enum ResponseStatus {
    SUCCESS("200"),
    ERROR("999"),
    PERMISSIONDENIED("500");
    private String code;

    ResponseStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
