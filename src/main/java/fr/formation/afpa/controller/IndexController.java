package fr.formation.afpa.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.afpa.dao.EmployeeDaoJpa;
import fr.formation.afpa.domain.Employee;



@Controller
//@RequestMapping(path="/admin")
public class IndexController {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unitBd");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	EmployeeDaoJpa dao = new EmployeeDaoJpa();

	// injecter service

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView getHome() {
		ModelAndView mv = new ModelAndView();
		List <Employee> liste = dao.findAll();
		mv.addObject("liste", liste);
		mv.setViewName("index");
		return mv;
	}

}
