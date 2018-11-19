package com.primeton.chengjianyun.demo.exception;

import com.primeton.chengjianyun.demo.enums.ErrorEnum;
import io.swagger.models.auth.In;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author chengjianyun
 * @date 2018/10/23 14:52
 */
public class ServiceException extends Exception{

    private final static String ERROR_CODE = "ErrCode: ";

    private final static String ERROR_MESSAGE = "Message: ";

    /**
     * http状态码
     */
    private HttpStatus httpStatus = HttpStatus.OK;
    /**
     * 异常码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ServiceException(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ServiceException(String message, Integer code, String message1, Object data) {
        super(message);
        this.code = code;
        this.message = message1;
        this.data = data;
    }

    public ServiceException(String message, Throwable cause, Integer code, String message1, Object data) {
        super(message, cause);
        this.code = code;
        this.message = message1;
        this.data = data;
    }

    public ServiceException(Throwable cause, Integer code, String message, Object data) {
        super(cause);
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code, String message1, Object data) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
        this.data = data;
    }
    public ServiceException(ErrorEnum errorEnum){
        this.code = Integer.valueOf(errorEnum.getCode());
        this.message = errorEnum.getMsg();
    }
    public ServiceException(ErrorEnum errorEnum,HttpStatus httpStatus){
        this.code = Integer.valueOf(errorEnum.getCode());
        this.message = errorEnum.getMsg();
        this.httpStatus = httpStatus;
    }
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
