package fr.formation.afpa.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.afpa.dao.EmployeeDaoJpa;
import fr.formation.afpa.domain.Employee;
import fr.formation.afpa.service.EmployeeService;



@Controller
//@RequestMapping(path="/admin")
//@RequestMapping(value="account")
public class IndexController {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unitBd");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EmployeeService dao = new EmployeeService();
	boolean isAuthenticated = false;

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
	public ModelAndView getEmployees(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("username") != null) {
			List <Employee> liste = dao.findAll();
			mv.addObject("liste", liste);
			mv.setViewName("employees");
			return mv;
		}
		mv.setViewName("redirect:/connexion");
		return mv;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getHome() {
		return "index";
	}

	@RequestMapping(path = "/updateEmployee", method = RequestMethod.GET)
	public ModelAndView updateEmployee(@RequestParam Integer empId, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("username") != null) {
			Employee e = dao.findById(empId);
			mv.addObject("employee", e);
			List <Employee> managers = dao.managersList();
			mv.addObject("managers", managers);
			mv.setViewName("updateEmployee");
			return mv;
		} else {
			mv.setViewName("redirect:/connexion");
			return mv;
		}
	}

	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public String contactPage() {
		return "contact";
	}

	@RequestMapping(path = "/deleteEmployee", method = RequestMethod.GET)
	public String delete(@RequestParam Integer empId, HttpSession session) {
		if (session.getAttribute("username") != null) {
			dao.deleteById(empId);
			return "redirect:/employees";
		} else {
			return "redirect:/connexion";
		}
	}

	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String aboutPage() {
		return "about";
	}

	@RequestMapping(path = "/addEmployee", method = RequestMethod.POST)
	public String add(@ModelAttribute Employee employee, @RequestParam("startDateString") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date formdate, @RequestParam("superiorEmpId") String superiorEmpId, HttpSession session) {
		if (session.getAttribute("username") != null) {
			if (formdate == null) {
				Date d = new Date();
				employee.setStartDate(d);
				employee.setChef(dao.findById(Integer.parseInt(superiorEmpId)));
			} else {
				employee.setStartDate(formdate);
			}
			dao.save(employee);
			return "redirect:/employees";
		} else {
			return "redirect:/connexion";
		}
	}

	@RequestMapping(path = "/updateEmployee", method = RequestMethod.POST)
	public String update(@ModelAttribute Employee employee, @RequestParam("startDateString") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date formdate, @RequestParam("superiorEmpId") String superiorEmpId) {
		if (formdate == null) {
			Date d = new Date();
			employee.setStartDate(d);
		} else {
			employee.setStartDate(formdate);
		}
		employee.setChef(dao.findById(Integer.parseInt(superiorEmpId)));
		dao.update(employee);
		return "redirect:/employees";
	}

	@RequestMapping(path = "/connexion", method = RequestMethod.GET)
	public String connexion() {
		return "connexion";
	}

	@RequestMapping(path = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("username") != null) {
			List <Employee> managers = dao.managersList();
			mv.addObject("managers", managers);
			mv.setViewName("addEmployee");
			return mv;
		} else {
			mv.setViewName("redirect:/connexion");
			return mv;
		}
	}

	@RequestMapping(path = "/managers", method = RequestMethod.GET)
	public ModelAndView getManagers(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("username") != null) {
			List <Employee> liste = dao.managersList();
			mv.addObject("liste", liste);
			mv.setViewName("managers");
			return mv;
		} else {
			mv.setViewName("redirect:/connexion");
			return mv;
		}
	}

	@RequestMapping(path = "/parametres", method = RequestMethod.GET)
	public ModelAndView getParametres(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("username") != null) {
			List <Employee> liste = dao.employeesNoManager();
			mv.addObject("liste", liste);
			mv.setViewName("parametres");
		} else {
			mv.setViewName("redirect:/connexion");
		}
		return mv;
	}

	@RequestMapping(path = "/connexion", method = RequestMethod.POST)
	public String connexionFormulaire(@RequestParam ("username") String name, @RequestParam ("password") String pwd, ModelMap map, HttpSession session) {
		String username = "root";
		String password = "123456";
		if(name.equals(username) && pwd.equals(password)) {
			session.setAttribute("username", name);
			return "redirect:/employees";
		} else {
			map.put("error", "<div class=\"alert alert-danger\" role=\"alert\">Identifiants incorrects.</div>");
			return "connexion";
		}
	}

	@RequestMapping(path = "/deconnexion", method = RequestMethod.GET)
	public String deconnexion(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:/";	
	}

}
