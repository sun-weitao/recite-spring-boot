package com.sun.recite.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.sun.recite.annotation.Rules;
import com.sun.recite.enums.ValidType;

import lombok.Data;
/**
 * 
 * @author sun-weitao
 * 单词
 */
@Entity
@Table(name = "word")
@Data
public class Word {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Rules(type = ValidType.NotNull,message = "单词不能为空")
	private String text;
	
	@Rules(type = ValidType.NotNull,message = "假名不能为空")
	private String kana;
	
	@Rules(type = ValidType.NotNull,message = "含义不能为空")
	private String meaning;
	
	@CreationTimestamp
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Example> examples;
	
	public List<Example> getExamples() {
		return examples;
	}

	public void setExamples(List<Example> examples) {
		this.examples = examples;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}


	
}
