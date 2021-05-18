package fr.formation.afpa.dao;

import java.util.List;

import fr.formation.afpa.domain.Department;

public interface IDepartmentDaoJpa {

	// Read
	Department findById(Integer id);
	List <Department> findAll();

	// Create
	void save(Department e);

	// Update
	void update(Department e);
	
	// Delete
	void delete(Department e);
	void deleteById(Integer id);

}
