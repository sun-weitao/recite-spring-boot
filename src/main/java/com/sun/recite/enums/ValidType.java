package com.sun.recite.enums;
import com.sun.recite.method.*;
import com.sun.recite.method.ValidMethod;

public enum ValidType {
	NotNull(new NotNull()),
	Email(new Email());
	
	private ValidMethod validMethod;
	
	ValidType(ValidMethod validMethod)
	{	
		this.validMethod = validMethod;
	}
	
	public ValidMethod getValidMethod() {
		return validMethod;
	}
}
