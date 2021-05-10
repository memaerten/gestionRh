package fr.formation.afpa.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDaoJpa<T extends Serializable> {
	EntityManagerFactory emf;
	EntityManager entitym;
	Class<T> entityClass;

	public AbstractDaoJpa() {
		emf = Persistence.createEntityManagerFactory("unitBd");
		entitym = emf.createEntityManager();
		ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
	}

	public void begin() {
		entitym.getTransaction().begin();
	}

	public void commit() {
		entitym.getTransaction().commit();
		entitym.close();
	}

	public T findById(Integer id) {
		return entitym.find(entityClass, id);
	}

	public List<T> findAll() {
		return entitym.createQuery("from" + entityClass.getName()).getResultList();
	}

	public void save(T entity) {
		entitym.persist(entity);
	}

	public void update(T entity) {
		entitym.merge(entity);

	}

	public void delete(T entity) {
		entitym.remove(entity);

	}

	public void deleteById(Integer id) {
		T obj = (T) findById(id);
		delete(obj);

	}

}
