package com.sun.recite.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.recite.annotation.Rules;
import com.sun.recite.enums.ValidType;

import lombok.Data;
/**
 * @author sun
 */
@Entity
@Table(name="sentence")
@Data
public class Sentence implements Serializable{
	
	@Id
	private String id;
	//句型
	@Rules(type = ValidType.NotNull,message = "句型不能为空")
	private String text;
	//含义
	@Rules(type = ValidType.NotNull,message = "含义不能为空")
	private String meaning;
	
	@Rules(type = ValidType.Email,message = "Email格式不正确")
	private String notice;

	private String method;

	private Date createTime;
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
