package com.demo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hibernate_Bidirectional_Course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	private int duration;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "c1", cascade = CascadeType.ALL)
	private Faculty f1;

	public Course(String cname, int duration, Faculty f1) {
		super();
		this.cname = cname;
		this.duration = duration;
		this.f1 = f1;
	}

	public Course() {
		super();
	}

	public Course(int cid, String cname, int duration, Faculty f1) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.duration = duration;
		this.f1 = f1;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Faculty getF1() {
		return f1;
	}

	public void setF1(Faculty f1) {
		this.f1 = f1;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", duration=" + duration + ", f1=" + f1 + "]";
	}
}
