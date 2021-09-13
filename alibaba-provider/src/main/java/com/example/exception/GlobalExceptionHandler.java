package com.example.exception;


import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 流控
    @ExceptionHandler(FlowException.class)
    public Map handleFlowException(Exception e, HttpServletRequest request) {
        String url = request.getRequestURI();
        log.error("url:【{}】流控异常", url, e);
        return new HashMap() {{
            put("code", -1);
            put("msg", "系统繁忙");
            put("data", null);
        }};
    }

    // 熔断降级
    @ExceptionHandler(DegradeException.class)
    public Map handleDegradeException(Exception e, HttpServletRequest request) {
        String url = request.getRequestURI();
        log.error("url:【{}】熔断降级异常", url, e);
        return new HashMap() {{
            put("code", -1);
            put("msg", "系统开小差");
            put("data", null);
        }};
    }

    // 权限规则
    @ExceptionHandler(AuthorityException.class)
    public Map handleAuthorityException(Exception e, HttpServletRequest request) {
        String url = request.getRequestURI();
        log.error("url:【{}】权限规则异常", url, e);
        return new HashMap() {{
            put("code", 300);
            put("msg", "，没有权限");
            put("data", null);
        }};
    }
}