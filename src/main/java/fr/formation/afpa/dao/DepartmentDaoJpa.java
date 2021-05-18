package fr.formation.afpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.afpa.domain.Department;

public class DepartmentDaoJpa implements IDepartmentDaoJpa {
	EntityManagerFactory emf;
	EntityManager entitym;

	public DepartmentDaoJpa() {
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
	public Department findById(Integer id) {
		return entitym.find(Department.class, id);
	}

	@Override
	public List<Department> findAll() {
		return entitym.createQuery("select department from Department department").getResultList();

	}

	@Override
	public void save(Department e) {
		begin();
		entitym.persist(e);
		commit();
	}

	@Override
	public void update(Department e) {
		begin();
		entitym.merge(e);
		commit();

	}

	@Override
	public void delete(Department e) {
		begin();
		entitym.remove(e);
		commit();

	}

	@Override
	public void deleteById(Integer id) {
		Department e = findById(id);
		delete(e);

	}
}
