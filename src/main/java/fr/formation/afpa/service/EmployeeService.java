package fr.formation.afpa.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.afpa.dao.EmployeeDaoJpa;
import fr.formation.afpa.dao.IGenericDao;
import fr.formation.afpa.domain.Employee;

public class EmployeeService implements IEmployeeService {
	//IGenericDao<Employee> dao;
	EmployeeDaoJpa dao = new EmployeeDaoJpa();
	
	@Autowired
	public void setDao(EmployeeDaoJpa dao) {
		this.dao = dao;
	}

	@Override
	public Employee findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}

	@Override
	public void save(Employee e) {
		dao.save(e);
	}

	@Override
	public void update(Employee e) {
		dao.update(e);
	}

	@Override
	public void delete(Employee e) {
		dao.delete(e);
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
	
	public List<Employee> managersList() {
		return dao.managersList();
	}
	
	public List<Employee> employeesNoManager() {
		return dao.employeesNoManager();
	}
}
