package com.sun.recite.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sun.recite.annotation.Validation;

public class ValidInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Handler   "+handler);
		if(handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod)handler;
			MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
			for(MethodParameter methodParameter:methodParameters) {
				
//				Annotation[] annotations = methodParameter.getParameterAnnotations();
//				for (Annotation annotation : annotations) {
//						if(annotation instanceof Validation) {
//							
//						}
//				}
			}
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
