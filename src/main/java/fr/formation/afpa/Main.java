package fr.formation.afpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.afpa.dao.EmployeeDaoJpa;
import fr.formation.afpa.domain.Employee;

public class Main {
	public static final Log log = LogFactory.getLog(Main.class);
	
	public static void main(String[] args) {
		
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("unitBd");
    	
    	EntityManager emanager = emf.createEntityManager();
		
		EmployeeDaoJpa dao = new EmployeeDaoJpa();
		List<Employee> liste = dao.findAll();
		for(Employee e : liste) {
			System.out.println(e);
		}
		
	}
}
