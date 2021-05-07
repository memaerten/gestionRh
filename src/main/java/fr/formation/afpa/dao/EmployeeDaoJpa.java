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
		entitym.persist(e);
		return e.getEmpId();
	}

	@Override
	public Employee update(Employee e) {
		return entitym.merge(e);

	}

	@Override
	public void delete(Employee e) {
		entitym.remove(e);

	}

	@Override
	public void deleteById(Integer id) {
		Employee e = findById(id);
		delete(e);

	}

}
