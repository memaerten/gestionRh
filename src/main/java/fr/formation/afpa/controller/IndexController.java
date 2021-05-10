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

	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public ModelAndView getEmployees() {
		ModelAndView mv = new ModelAndView();
		List <Employee> liste = dao.findAll();
		mv.addObject("liste", liste);
		mv.setViewName("employees");
		return mv;
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getHome() {
		return "index";
	}
	
	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public String contactPage() {
		return "contact";
	}
	
	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String aboutPage() {
		return "about";
	}
	
	@RequestMapping(path = "/connexion", method = RequestMethod.GET)
	public String connexion() {
		return "connexion";
	}
	
	@RequestMapping(path = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee() {
		ModelAndView mv = new ModelAndView();
		List <Employee> managers = dao.findAll();
		mv.addObject("managers", managers);
		mv.setViewName("addEmployee");
		return mv;
	}
	
	@RequestMapping(path = "/managers", method = RequestMethod.GET)
	public ModelAndView getManagers() {
		ModelAndView mv = new ModelAndView();
		List <Employee> liste = dao.findAll();
		mv.addObject("liste", liste);
		mv.setViewName("managers");
		return mv;
	}
	
	@RequestMapping(path = "/parametres", method = RequestMethod.GET)
	public ModelAndView getParametres() {
		ModelAndView mv = new ModelAndView();
		List <Employee> liste = dao.findAll();
		mv.addObject("liste", liste);
		mv.setViewName("parametres");
		return mv;
	}

}
