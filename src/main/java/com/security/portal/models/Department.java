package com.security.portal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long  id;
	private String deptId;
	private String deptName;
	private String hodName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getHodName() {
		return hodName;
	}
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptId=" + deptId + ", deptName=" + deptName + ", hodName=" + hodName + "]";
	}
	public Department(Long id, String deptId, String deptName, String hodName) {
		super();
		this.id = id;
		this.deptId = deptId;
		this.deptName = deptName;
		this.hodName = hodName;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
