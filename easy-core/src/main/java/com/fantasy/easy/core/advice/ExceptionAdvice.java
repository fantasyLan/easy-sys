/**
 * ExceptionAdvice.java
 * @author Fantasy Lan
 */
package com.fantasy.easy.core.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fantasy.easy.core.SessionSubjectUtils;
import com.fantasy.easy.core.exception.EasyApplicationException;
import com.fantasy.easy.core.vo.EasyMessage;

/**
 * @author Fantasy Lan
 * @since 2019年12月4日 : 下午10:32:29
 * 统一异常处理
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(EasyApplicationException.class)
    public EasyMessage handleEasyApplicationException(EasyApplicationException e){
    	System.out.println("错误处理：");
    	SessionSubjectUtils.setIsException(true);
        return EasyMessage.failMessage(e.getErrorCode(), e.getMessage(), null);
    }
    
    @ExceptionHandler(Exception.class)
    public EasyMessage handleException(Exception e){
    	SessionSubjectUtils.setIsException(true);
    	e.printStackTrace();
        return EasyMessage.failMessage("系统错误", e.getMessage(), null);
    }
}
