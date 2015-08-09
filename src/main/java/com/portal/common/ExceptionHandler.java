package com.portal.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver {

  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    String message = "未知错误！";
    if (ex != null && ex.getMessage() != null) {
      message = ex.getMessage();
    }
    request.setAttribute("message", message);
    return new ModelAndView("error/error");
  }
}
