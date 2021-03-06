package com.primeton.chengjianyun.demo.exception;

import com.primeton.chengjianyun.demo.model.ResultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.OK;

/**
 * @author chengjianyun
 * @date 2018/10/23 14:42
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResultResponse> exceptionHandler(HttpServletRequest request, Exception e, ServiceException me) throws Exception{
        ResponseEntity<ResultResponse> re = null;
        if(e instanceof ServiceException){
            re = new ResponseEntity<ResultResponse>(new ResultResponse(me.getCode().toString(),me.getMessage()),OK);
            logger.error("异常编码:"+me.getCode(),e.getMessage(),e);
        }else{
            re = new ResponseEntity<ResultResponse>(new ResultResponse(),me.getHttpStatus());
            logger.error("异常信息:",e.getMessage(),e);
        }
        return re;
    }

//    @ResponseBody
//    @ExceptionHandler(value = ServiceException.class)
//    public Map serviceExceptionHandler(ServiceException e) throws Exception{
//        Map map = new HashMap();
//        map.put("code",e.getCode());
//        map.put("msg",e.getMessage());
//        logger.error("异常编码:"+e.getCode(),e.getMessage(),e);
//        return map;
//    }
}
