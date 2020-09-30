package com.sun.recite.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sun.recite.annotation.Rules;
import com.sun.recite.annotation.Validation;
import com.sun.recite.entity.Sentence;

public class ValidInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
//		if(handler instanceof HandlerMethod) {
//			HandlerMethod handlerMethod = (HandlerMethod)handler;
//			MethodParameter[] methodParameters = handlerMethod.getMethodParameters();	
//			for(MethodParameter methodParameter:methodParameters) {				
//				
//				Annotation[] annotations = methodParameter.getParameterAnnotations();
//				boolean isVaild = false;
//				for(Annotation annotation:annotations) {
//					if(annotation instanceof Validation) {//如果添加了验证
//						 isVaild = true;
//					}
//				}
//				if(isVaild) {
//					String className = methodParameter.getParameter().getType().getTypeName();
//					
//					Class<?> clazz = Class.forName(className);
//					Field[] fields = clazz.getDeclaredFields();
//					for (Field field:fields) {
//						Annotation[] fieldAnnotations = field.getAnnotations();
//						field.setAccessible(true);
//						for(Annotation fieldAnnotation:fieldAnnotations) {
//							if(fieldAnnotation instanceof Rules) {
//								Rules rules = (Rules)fieldAnnotation;
//								String message = rules.message();
////								System.out.println("message   "+message);
////								System.out.println("validType  "+rules.type().name()+"  " +rules.type().getValidMethod().valid(""));
//								
//							}
//						}
//					}
//				}
//			}
//		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
