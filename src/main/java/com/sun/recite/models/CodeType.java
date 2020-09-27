package com.sun.recite.models;

public enum CodeType {
	
	Defind("禁止",50008);
	
	private String msg;
	private int code;
	CodeType(String msg,int code)
	{
		this.msg = msg;
		this.code = code;
	}
}
