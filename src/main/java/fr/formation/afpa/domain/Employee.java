package fr.formation.afpa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "emp_id",unique = true, nullable = false)
	private Integer empId;
	
	@Column(name="first_name", nullable = false, length=30)
	private String firstName;
	
	@Column(name="last_name", nullable = false, length=30)
	private String lastName;
	
	@Column(name="start_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name="title", nullable = false, length=30)
	private String title;
	
	@Column(name="end_date", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name= "dept_id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name= "superior_emp_id")
	private Employee chef;
	
	@ManyToMany
	@JoinTable(name="employees_has_department", joinColumns = {
	@JoinColumn(name="employee_id") },inverseJoinColumns = {
	@JoinColumn(name="department_id")})
	private Set <Department> departmentOfEmployee = new HashSet<Department>();
	
	private List<Department> listDepartements;
	
	public Employee getChef() {
		return chef;
	}
	public void setChef(Employee chef) {
		this.chef = chef;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", startDate="
				+ startDate + ", title=" + title + ", endDate=" + endDate + "]";
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Employee() {
	}



}
