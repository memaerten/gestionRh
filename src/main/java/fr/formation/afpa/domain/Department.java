package fr.formation.afpa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id", unique = true, nullable = false)
	private int deptId;
	
	@Column
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER ,mappedBy = "department")
	private Set<Employee> employees = new HashSet<Employee>();
	

	

	public Set<Employee> getEmployees() {
		return employees;
	}

	@ManyToMany(fetch= FetchType.EAGER, mappedBy = "employee")
	public void setEmployees(Set<Employee> exmployees) {
		this.employees = employees;
	}

	public Department() {
		
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + "]";
	}
	
	
}
