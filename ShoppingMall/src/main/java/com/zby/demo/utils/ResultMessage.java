package com.zby.demo.utils;

import com.google.gson.Gson;

public class ResultMessage {
    private String code;
    private String message;
    private Object data;
    public ResultMessage () {

    }
    public ResultMessage (Object data) {
        this.code = "200";
        this.data = data;
    }
    public ResultMessage (String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String data () {
        return getJsonResult(this.code, this.message, this.data);
    }

    public static String error (String message) {
        return getJsonResult("999", message, null);
    }
    public static String success (String message) {
        return getJsonResult("200", message, null);
    }
    private static String getJsonResult (String code, String message, Object data) {
        ResultMessage result = new ResultMessage();
        result.code = code;
        result.message = message;
        result.data = data;
        return new Gson().toJson(result);
    }
}
