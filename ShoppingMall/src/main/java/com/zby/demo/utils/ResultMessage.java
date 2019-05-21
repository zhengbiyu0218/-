package com.zby.demo.utils;

import com.google.gson.Gson;

public class ResultMessage {
    private String code;
    private String message;
    private Object data;
    public ResultMessage () {

    }
    public ResultMessage (Object data) {
        this.code = ResponseStatus.SUCCESS.getCode();
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
    public static String data (Object data) {
        return getJsonResult(ResponseStatus.SUCCESS.getCode(), null, data);
    }
    public static String denied () {
        return getJsonResult(ResponseStatus.PERMISSIONDENIED.getCode(), "请登录后操作", null);
    }
    public static String error (String message) {
        return getJsonResult(ResponseStatus.ERROR.getCode(), message, null);
    }
    public static String success (String message) {
        return getJsonResult(ResponseStatus.SUCCESS.getCode(), message, null);
    }
    public static String success (String message, Object data) {
        return getJsonResult(ResponseStatus.SUCCESS.getCode(), message, data);
    }
    private static String getJsonResult (String code, String message, Object data) {
        ResultMessage result = new ResultMessage();
        result.code = code;
        result.message = message;
        result.data = data;
        return new Gson().toJson(result);
    }
    private static String getJsonResult (ResponseStatus status, String message, Object data) {
        ResultMessage result = new ResultMessage();
        result.code = status.getCode();
        result.message = message;
        result.data = data;
        return new Gson().toJson(result);
    }
}
