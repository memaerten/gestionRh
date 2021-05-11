package fr.formation.afpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.afpa.domain.Employee;

public class EmployeeDaoJpa implements IEmployeeDaoJpa {
	EntityManagerFactory emf;
	EntityManager entitym;

	public EmployeeDaoJpa() {
		emf = Persistence.createEntityManagerFactory("unitBd");
		entitym = emf.createEntityManager();
	}

	public void begin() {
		entitym.getTransaction().begin();
	}

	public void commit() {
		entitym.getTransaction().commit();
	}
	
	public void close() {
		entitym.close();
	}

	@Override
	public Employee findById(Integer id) {
		return entitym.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		return entitym.createQuery("select emp from Employee emp").getResultList();

	}

	@Override
	public Integer save(Employee e) {
		begin();
		entitym.persist(e);
		commit();
		return e.getEmpId();
	}

	@Override
	public void update(Employee e) {
		begin();
		entitym.merge(e);
		commit();

	}

	@Override
	public void delete(Employee e) {
		begin();
		entitym.remove(e);
		commit();

	}

	@Override
	public void deleteById(Integer id) {
		Employee e = findById(id);
		delete(e);

	}
	
	public List<Employee> managersList() {
		return entitym.createQuery("select distinct emp.chef from Employee emp").getResultList();
	}
	
	public List<Employee> employeesManaged(Integer i) {
		return entitym.createQuery("select emp from Employee emp where emp.chef.empId =" + i).getResultList();
	}

}
