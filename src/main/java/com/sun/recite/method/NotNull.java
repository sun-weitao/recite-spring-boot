package com.sun.recite.method;

import org.springframework.util.StringUtils;

public class NotNull<T> implements ValidMethod{

	@Override
	public <T> boolean valid(T value) {
		return !StringUtils.isEmpty(value);
	}
}
