package com.sun.recite.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="sentence")
@Data
public class Sentence implements Serializable{
	
	@Id
	private String id;
	//句型
	private String text;
	//含义
	private String meaning;
	
}
