package fr.formation.afpa.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class GenericDAO<T extends Serializable> extends AbstractDaoJpa<T> {

//	private Class<T> entityClass;
//	private Session currentSession;
//	private Transaction currentTx;
//
//	public GenericDAO() {
//		ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
//		this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
//	}
//
//	public void closeCurrentSession() {
//		currentSession.close();
//	}
//
//	private static SessionFactory getSessionFactory() {
//		Configuration cf = new Configuration().configure();
//		StandardServiceRegistryBuilder b = new StandardServiceRegistryBuilder().applySettings(cf.getProperties());
//		SessionFactory sf = cf.buildSessionFactory(b.build());
//
//		return sf;
//
//	}
//
//	public Session openCurrentSession() {
//		currentSession = getSessionFactory().openSession();
//		return currentSession;
//	}
//
//	public Session openCurrentSessionWithTx() {
//		currentSession = getSessionFactory().openSession();
//		currentTx = currentSession.beginTransaction();
//		return currentSession;
//	}
//
//	public void closeCurrentSessionWithTx() {
//		currentTx.commit();
//		currentSession.close();
//	}
//
//
//	public Session getCurrentSession() {
//		return currentSession;
//	}
//
//	public void setCurrentSession(Session currentSession) {
//		this.currentSession = currentSession;
//	}
//
//	
//	public T findbyId(Integer id) {
//		return getCurrentSession().load(entityClass, id);
//	}
//
//	@Override
//	public List<T> findAll() {
//		return getCurrentSession().createQuery("select t from " + entityClass.getSimpleName() + " t").list();
//	}
//
//	@Override
//	public T save(T t) {
//		getCurrentSession().save(t);
//		return t;
//	}
//
//	@Override
//	public T saveOrUpdate(T t) {
//		getCurrentSession().saveOrUpdate(t);
//		return t;
//	}
//
//	@Override
//	public T update(T t) {
//		getCurrentSession().update(t);
//		return t;
//	}
//
//	@Override
//	public void delete(T t) {
//		getCurrentSession().delete(t);
//
//	}
//
//	@Override
//	public void deleteById(I id) {
//		delete(findbyId(id));
//
//	}

}
