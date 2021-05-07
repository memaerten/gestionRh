package fr.formation.afpa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	//	@RequestMapping(path = "/formulaire", method = RequestMethod.GET)
	//	public String getFormulaire() {
	//		return "formulaire";
	//	}
	//	
	//	@RequestMapping(path = "/formulaireDate", method = RequestMethod.POST)
	//	public String getFormulaire2(Model model, @RequestParam("formdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date formdate) {
	//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	//		String strDate = formatter.format(formdate);
	//		model.addAttribute("formdate", strDate);
	//		return "formulaireDate";
	//	}
	//
	//	//	@GetMapping(path = "/hello/path") // /admin/hello
	//	//	public String getHome() {
	//	//		return "index";
	//	//	}
	//
	//	@RequestMapping(path = "/hello/{subpath}", method = RequestMethod.GET) // /admin/hello
	//	public ModelAndView helloSpringMvcPage(@PathVariable("subpath") String subpath) {
	//		ModelAndView mv= new ModelAndView();
	//		if(subpath.equals("hello")) {
	//			mv.setViewName("redirect:/hello");
	//		} else {
	//			mv.addObject("message", "Spring MVC : @PathVariable");
	//			mv.setViewName("redirect:/");
	//		}
	//		return mv;
	//	}
	//	
	//	@RequestMapping(path = "/hello", method = RequestMethod.GET) // /admin/hello
	//	public ModelAndView helloPage() {
	//		ModelAndView mv= new ModelAndView();
	//		mv.addObject("message", "Spring MVC");
	//		mv.setViewName("hello");
	//		return mv;
	//	}
	//	
	//	@GetMapping(path="/form")
	//	public String displayForm(@ModelAttribute Customer customer) {
	//		return "customerform";
	//	}
	//	
	//	@PostMapping(path = "/hello")
	//	public String helloMapping(Model model, @RequestParam String name) {
	//		model.addAttribute("message", name);
	//		return "index";
	//	}
	//	
	//	@PostMapping(path = "/save")
	//	public String processForm(Model model, @ModelAttribute Customer customer, BindingResult result) {
	//		ValidationUtils.rejectIfEmpty(result, "custId", "label.empty");
	//		ValidationUtils.rejectIfEmpty(result, "custTypeCd", "label.empty");
	//		ValidationUtils.rejectIfEmpty(result, "name", "label.empty");
	//		ValidationUtils.rejectIfEmpty(result, "address", "label.empty");
	//		ValidationUtils.rejectIfEmpty(result, "email", "label.empty");
	//		ValidationUtils.rejectIfEmpty(result, "fedId", "label.empty");
	//		
	//		if(result.hasErrors()) {
	//			System.out.println("Champs incorrects. L'envoie du formulaire est annulé.");
	//			System.out.println(result.getAllErrors());
	//			
	//			return "redirect:/form";
	//		}
	//		if(!customer.getEmail().matches("[A-Za-z].*@[A-Za-z].*\\.[A-Za-z]{2,5}")) {
	//			return "redirect:/form";
	//			
	//		}
	//		model.addAttribute("name", customer.getName());
	//		model.addAttribute("address", customer.getAddress());
	//		model.addAttribute("email", customer.getEmail());
	//		model.addAttribute("fedId", customer.getFedId());
	//		model.addAttribute("custTypeCd", customer.getCustTypeCd());
	//		System.out.println(customer);
	////		model.addAttribute("message", name);
	//		return "success";
	//	}
	//
	//	//	@RequestMapping(path = "/hello", method = RequestMethod.POST)
	//	//	public ModelAndView hello(HttpServletRequest request) {
	//	//		String nameParam = request.getParameter("name");
	//	//		ModelAndView model = new ModelAndView("index");
	//	//		model.addObject("message", nameParam);
	//	//		return model;
	//	//	}
	//
	//	//	@RequestMapping(path = "/hello",  method = RequestMethod.POST)
	//	//	public ModelAndView hello(HttpServletRequest request) {
	//	//		String nameParam = request.getParameter("name");
	//	//		ModelAndView model = new ModelAndView("index");
	//	//		model.addObject("message", nameParam);
	//	//		return model;
	//	//	}

}
