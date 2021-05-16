package fr.formation.afpa.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.afpa.config.EmployeeValidator;
import fr.formation.afpa.dao.DepartmentDaoJpa;
import fr.formation.afpa.domain.Department;
import fr.formation.afpa.domain.Employee;
import fr.formation.afpa.service.EmployeeService;



@Controller
//@RequestMapping(path="/admin")
//@RequestMapping(value="account")
public class IndexController {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unitBd");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EmployeeService dao = new EmployeeService();
	DepartmentDaoJpa depdao = new DepartmentDaoJpa();
	
	boolean isAuthenticated = false;
	

    @Autowired
    private EmployeeValidator employeeValidator;

    @InitBinder
    protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) {
        binder.addValidators(employeeValidator);
    }

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
			List<Department> departments = depdao.findAll();
			mv.addObject("managers", managers);
			mv.addObject("departments", departments);
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
	public String add(@ModelAttribute Employee employee, @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date formdate, @RequestParam("superiorEmpId") String superiorEmpId, @RequestParam("depId") String departmentId, HttpSession session, BindingResult result) {
		if (session.getAttribute("username") != null) {
			employeeValidator.validate(employee, result);
			if(result.hasErrors()) {
				return "redirect:/addEmployee";
			}
			
			if (formdate == null) {
				Date d = new Date();
				employee.setStartDate(d);
			} else {
				employee.setStartDate(formdate);
			}
			if (superiorEmpId.equals("null")) {
				employee.setChef(null);	
			} else {
				employee.setChef(dao.findById(Integer.parseInt(superiorEmpId)));
			}
			if (departmentId.equals("null")) {
				employee.setDepartment(null);	
			} else {
				employee.setDepartment(depdao.findById(Integer.parseInt(departmentId)));
			}
			dao.save(employee);
			return "redirect:/employees";
		} else {
			return "redirect:/connexion";
		}
	}

	@RequestMapping(path = "/updateEmployee", method = RequestMethod.POST)
	public String update(@ModelAttribute Employee employee, @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date formdate, @RequestParam("depId") String departmentId, @RequestParam("superiorEmpId") String superiorEmpId, BindingResult result) {
		employeeValidator.validate(employee, result);
		if (formdate == null) {
			Date d = new Date();
			employee.setStartDate(d);
		} else {
			employee.setStartDate(formdate);
		}
		if (superiorEmpId.equals("null")) {
			employee.setChef(null);	
		} else {
			employee.setChef(dao.findById(Integer.parseInt(superiorEmpId)));
		}
		if (departmentId.equals("null")) {
			employee.setDepartment(null);	
		} else {
			employee.setDepartment(depdao.findById(Integer.parseInt(departmentId)));
		}
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
			List<Department> departments = depdao.findAll();
			mv.addObject("managers", managers);
			mv.addObject("departments", departments);
			mv.addObject("date", new Date());
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
