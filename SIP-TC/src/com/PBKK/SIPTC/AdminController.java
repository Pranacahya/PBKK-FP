package com.PBKK.SIPTC;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@Controller
public class AdminController {
	private String tableName = "admin";
	
	public String loginPageAdmin() {
		return "login";
	}
	
	public String registerPageAdmin() 
	{
		return "register_admin";
	}
	
	public String processLogin(HttpServletRequest request, Model model) 
	{
		String nrp_admin = request.getParameter("username");
		String password = request.getParameter("password");
		
		SessionFactory factory = generateSession();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		String hql_get = "FROM " + Admin.class.getName() + " a WHERE a.nrp_admin = :username AND a.password = :password";
		Query query = session.createQuery(hql_get);
		query.setParameter("username", nrp_admin);
		query.setParameter("password", password);
		List admin = query.list();
		
		return "";
	}
	
	@RequestMapping("/testproc")
	public String testProc(Model model)
	{
		String nrp_admin = "Yoga";
		String password = "yoga";
		
		SessionFactory factory = generateSession();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		String hql_get = "FROM " + Admin.class.getName() + " a WHERE a.nrp_admin = :username AND a.password = :password";
		Query query = session.createQuery(hql_get);
		query.setParameter("username", nrp_admin);
		query.setParameter("password", password);
		List<Admin> admin = query.list();
		
		model.addAttribute("Nama", admin.get(0).getNama_admin());
		model.addAttribute("NRP", admin.get(0).getNrp_admin());
		model.addAttribute("Email admin", admin.get(0).getEmail_admin());
		
		return "test";
	}
	
	public SessionFactory generateSession()
	{
		return new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Admin.class)
				.buildSessionFactory();
	}
	
}
