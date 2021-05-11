package fr.formation.afpa.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
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

//	private boolean isAuthenticated() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication == null || AnonymousAuthenticationToken.class.
//				isAssignableFrom(authentication.getClass())) {
//			return false;
//		}
//		return authentication.isAuthenticated();
//	}

	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public ModelAndView getEmployees() {
		ModelAndView mv = new ModelAndView();
		//if(isAuthenticated()) {
			List <Employee> liste = dao.findAll();
			mv.addObject("liste", liste);
			mv.setViewName("employees");
			return mv;
//		} else {
//			mv.setViewName("redirect:/connexion");
//			return mv;
//		}

	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getHome() {
		return "index";
	}

	@RequestMapping(path = "/updateEmployee", method = RequestMethod.GET)
	public ModelAndView updateEmployee(@RequestParam Integer empId) {
		ModelAndView mv = new ModelAndView();
		Employee e = (Employee) dao.findById(empId);
		mv.addObject("employee", e);
		mv.setViewName("updateEmployee");
		return mv;
	}

	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public String contactPage() {
		return "contact";
	}

	@RequestMapping(path = "/deleteEmployee", method = RequestMethod.GET)
	public String delete(@RequestParam Integer empId) {
		dao.deleteById(empId);
		return "redirect:/employees";
	}

	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String aboutPage() {
		return "about";
	}

	@RequestMapping(path = "/addEmployee", method = RequestMethod.POST)
	public String add(@ModelAttribute Employee employee, @RequestParam("startDateString") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date formdate) {
		if (formdate == null) {
			Date d = new Date();
			employee.setStartDate(d);
		} else {
			employee.setStartDate(formdate);
		}
		dao.save(employee);
		return "redirect:/employees";
	}

	@RequestMapping(path = "/updateEmployee", method = RequestMethod.POST)
	public String update(@ModelAttribute Employee employee, @RequestParam("startDateString") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date formdate) {
		if (formdate == null) {
			Date d = new Date();
			employee.setStartDate(d);
		} else {
			employee.setStartDate(formdate);
		}
		dao.update(employee);
		return "redirect:/employees";
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

	@RequestMapping(path = "/connexion", method = RequestMethod.POST)
	public String connexionFormulaire(@RequestParam ("username") String name, @RequestParam ("password") String pwd) {
		ModelAndView mv = new ModelAndView();
		String username = "root";
		String password = "123456";
		if(name.equals(username) && pwd.equals(password)) {

			return "redirect:/employees";
		} else {
			return "connexion";
		}
	}

	@RequestMapping(path = "/deconnexion", method = RequestMethod.GET)
	public String deconnexion(SessionStatus status) {
		status.setComplete();
		return "index";	
	}

}
