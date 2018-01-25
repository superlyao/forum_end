package com.yliao.config;

import com.yliao.bean.dto.ErrorInfo;
import com.yliao.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liaoyao
 * @Date 2017/12/27.
 * 全局处理异常配置类
 */
@ControllerAdvice
public class ApplicationExceptionHandler {
    /**
     * 发生为捕获的异常时返回error页面
     * @param request
     * @param e
     * @return
     */
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("com/yliao/exception", e);
//        modelAndView.addObject("message", e.getMessage());
//        modelAndView.setViewName("error");
//        return modelAndView;
    /**
     * 捕获业务异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = {BusinessException.class, Exception.class})
    @ResponseBody
    public Map<String, Object> BuisinessException(HttpServletRequest request, BusinessException e) {
        Map<String, Object> errorResult = new HashMap<String, Object>();
        errorResult.put("code", ErrorInfo.ERROR + "");
        errorResult.put("message", e.getMessage());
        errorResult.put("url", request.getRequestURL().toString());
        errorResult.put("success", false);
        return errorResult;
    }

//    }
}
