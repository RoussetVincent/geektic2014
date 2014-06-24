package com.ninja_squad.geektic.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="geek")
@SequenceGenerator(sequenceName="geek_seq", name = "geek_seq")
public class Geek {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="geek_seq")
	private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Sex sex;
	@Enumerated(EnumType.STRING)
	private Interest interests;	
	private String avatar;

	public Geek() {
	}

	public Geek(String name, Sex sex, Interest interests, String avatar ) {
		this.name = name;
		this.sex = sex;
		this.interests = interests;
		this.avatar = avatar;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Interest getInterests() {
		return interests;
	}

	public void setInterests(Interest interests) {
		this.interests = interests;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
