package com.sun.recite.aspect;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.sun.recite.annotation.Rules;
import com.sun.recite.annotation.Validation;
import com.sun.recite.exception.ValidException;



@Aspect
@Component
public class ValidAspect {
	
	@Before("execution(* com.sun.recite.controller.*.*(..))")
	public void around(JoinPoint joinPoint) throws IllegalArgumentException, IllegalAccessException {
		
		Object[] args = joinPoint.getArgs();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Parameter[] parameters = signature.getMethod().getParameters();
		for(int i =0;i<parameters.length;i++) {
			Parameter parameter = parameters[i];
			Object obj = args[i];
			
			if(parameter.getAnnotation(Validation.class) != null)
			{
				Field[] fields = parameter.getType().getDeclaredFields();
				for(Field field:fields) {
					field.setAccessible(true);
					if(field.getAnnotation(Rules.class) != null) {
						Rules rules = field.getAnnotation(Rules.class);
						Object value = field.get(obj);
						if(!rules.type().getValidMethod().valid(value)) {
							throw new ValidException(rules.message());
						}
					}
				}
			}
		}
		
	}
}
