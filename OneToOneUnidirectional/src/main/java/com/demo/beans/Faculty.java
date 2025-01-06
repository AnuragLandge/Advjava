package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hibernate_Faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	private String fname;
	private String address;
	@OneToOne(fetch = FetchType.LAZY)
	private Course c;

	public Faculty() {
		super();
	}

	public Faculty(String fname, String address, Course c) {
		super();
		this.fname = fname;
		this.address = address;
		this.c = c;
	}

	public Faculty(int fid, String fname, String address, Course c) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.address = address;
		this.c = c;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Course getC() {
		return c;
	}

	public void setC(Course c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", address=" + address + ", c=" + c + "]";
	}

}
