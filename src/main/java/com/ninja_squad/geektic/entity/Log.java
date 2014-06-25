package com.ninja_squad.geektic.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="log")
@SequenceGenerator(sequenceName="log_seq", name = "log_seq")
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="log_seq")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "ID_GEEK")
	private Geek geek;
	private String ipadress;
	private Date hour;

	/* Constructor */
	public Log(Geek geek) {
		this.geek = geek;
		this.ipadress = "0.0.0.0";
		this.hour = new Date();
	}

	/* GETTER / Setter */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Geek getGeek() {
		return geek;
	}

	public void setGeek(Geek geek) {
		this.geek = geek;
	}

	public String getIpadress() {
		return ipadress;
	}

	public void setIpadress(String ipadress) {
		this.ipadress = ipadress;
	}

	public Date getHour() {
		return hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

}
