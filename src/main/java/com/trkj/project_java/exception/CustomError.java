package com.trkj.project_java.exception;
@SuppressWarnings("ALL")
public class CustomError extends RuntimeException {
    //异常错误编码
    private int code;
    //异常信息
    private String message;

    private CustomError() {
    }

    public CustomError(CustomErrorType exceptionTypeEnum, String message) {
        this.code = exceptionTypeEnum.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}