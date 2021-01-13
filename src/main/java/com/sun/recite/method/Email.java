package com.sun.recite.method;

import java.util.regex.Pattern;

public class Email<String> implements ValidMethod{

	@Override
	public <String> boolean valid(String value) {
		return Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", (CharSequence) value);
	}

}
