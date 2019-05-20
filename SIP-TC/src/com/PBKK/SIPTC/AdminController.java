package com.PBKK.SIPTC;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.PBKK.SIPTC.Admin;

@Controller
public class AdminController {
	
	@RequestMapping(value="/adminlogin")
	public String loginPageAdmin() {
		return "login_admin2";
	}
	
	public String registerPageAdmin() 
	{
		return "register_admin";
	}
	
	@RequestMapping(value="/dashboard_admin", method=RequestMethod.GET)
	public String dashboardAdmin(HttpSession session) 
	{
		Admin admin = (Admin)session.getAttribute("admin_data");
		if (admin == null) {
			return "index";
		}
		else
			return "dashboard_admin";
	}
	
	@RequestMapping(value="/processloginadmin", method=RequestMethod.POST)
	public String processLogin(HttpServletRequest request, 
			Model model) 
	{
		String nrp_admin = request.getParameter("nrp_admin");
		String password = request.getParameter("password");
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Admin.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		String hql_get = "FROM " + Admin.class.getName() + " a WHERE a.nrp_admin = :username AND a.password = :password";
		Query query = session.createQuery(hql_get);
		query.setParameter("username", nrp_admin);
		query.setParameter("password", password);
		List<Admin> admins = query.list();
		
		String return_page = "login_admin2";
		
		try {
			Admin admin_data = admins.get(0);
			request.getSession().setAttribute("admin_data", admin_data);
			
			return_page = "dashboard_admin";
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return return_page;
	}
	
	@RequestMapping(value="/logout")
	public String logout_admin(HttpServletRequest request) 
	{
		request.getSession().invalidate();
		return "menu";
	}
	
	@RequestMapping("/testproc")
	public String testProc(Model model)
	{
		String nrp_admin = "05111540000080";
		String password = "yoga";
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Admin.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		String hql_get = "FROM " + Admin.class.getName() + " a WHERE a.nrp_admin = :username AND a.password = :password";
		Query query = session.createQuery(hql_get);
		query.setParameter("username", nrp_admin);
		query.setParameter("password", password);
		List<Admin> admin = query.list();
		
		model.addAttribute("Nama", admin.get(0).getNama_admin());
		model.addAttribute("Nrp", admin.get(0).getNrp_admin());
		model.addAttribute("Email_admin", admin.get(0).getEmail_admin());
		
		return "test";
	}
}
