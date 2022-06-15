package org.noneorone.boot.thymeleaf.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * ControllerAdvice注解是当前项目所有类的统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseBody // 返回JSON
    public Object globalErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        System.out.println("GlobalExceptionHandler globalErrorHandler(): " + e);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("message", e.getLocalizedMessage());
        map.put("url", request.getRequestURL().toString());
        map.put("data", "请求失败");
        return map;
    }

}
