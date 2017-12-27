package config;

import entity.dto.ErrorInfo;
import exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author liaoyao
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
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("message", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    /**
     * 捕获业务异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ErrorInfo<String> BuisinessException(HttpServletRequest request, BusinessException e) {
        ErrorInfo<String> errorInfo = new ErrorInfo<String>();
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setMessage(e.getMessage());
        errorInfo.setData("发生错误");
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }
}
