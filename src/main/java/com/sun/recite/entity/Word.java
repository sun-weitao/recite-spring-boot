package com.sun.recite.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "word")
@Data
public class Word {
	@Id
	private String id;
	
	private String text;
	
	private String kana;
	
	private String meaning;
	
	private Date createTime;
	
	private Date updateTime;
	
}
