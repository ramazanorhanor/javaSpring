package com.ramazan.domain.employee;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long JobId;
	@Column
	private String JobTitle;
	@Column
	private double minSalary;
	@Column
	private double maxSalary;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "job")
	private List<Employee> employees;
	
	/*
	* job ile employee arasýnda bire çok iliþki var 
	 * bir employee bir job 
	 * bir job -- çok employee
	 */
	public Job() {
		
	}
	public Job(String jobTitle, double minSalary, double maxSalary, List<Employee> employees) {
		super();
		JobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.employees = employees;
	}
	public Long getJobId() {
		return JobId;
	}
	public void setJobOd(Long jobId) {
		JobId = jobId;
	}
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	public double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}
	public double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((JobId == null) ? 0 : JobId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		if (JobId == null) {
			if (other.JobId != null)
				return false;
		} else if (!JobId.equals(other.JobId))
			return false;
		return true;
	}
	
}
