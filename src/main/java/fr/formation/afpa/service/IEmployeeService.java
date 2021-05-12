package fr.formation.afpa.service;

import java.util.List;

import fr.formation.afpa.dao.IGenericDao;
import fr.formation.afpa.domain.Employee;

public interface IEmployeeService {

	// Read
	Employee findById(Integer id);
	List <Employee> findAll();

	// Create
	void save(Employee e);

	// Update
	void update(Employee e);
	
	// Delete
	void delete(Employee e);
	void deleteById(Integer id);
	
}
