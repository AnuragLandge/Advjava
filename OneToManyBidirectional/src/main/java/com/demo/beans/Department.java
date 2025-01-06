package com.demo.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Hibernate_Department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	private String deptName;
	private String deptLoc;
	@OneToMany(mappedBy = "dept")
	Set<Employee> elist;

	public Department() {
		super();
	}

	public Department(String deptName, String deptLoc, Set<Employee> elist) {
		super();
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		this.elist = elist;
	}

	public Department(int deptId, String deptName, String deptLoc, Set<Employee> elist) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		this.elist = elist;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	public Set<Employee> getElist() {
		return elist;
	}

	public void setElist(Set<Employee> elist) {
		this.elist = elist;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptLoc=" + deptLoc + ", elist=" + elist
				+ "]";
	}

}
