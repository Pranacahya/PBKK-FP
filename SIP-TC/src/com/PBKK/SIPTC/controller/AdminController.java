package com.PBKK.SIPTC.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PBKK.SIPTC.dao.AdminDAO;
import com.PBKK.SIPTC.dao.StatusDAO;
import com.PBKK.SIPTC.dao.TransaksiDAO;
import com.PBKK.SIPTC.entity.Admin;
import com.PBKK.SIPTC.entity.Status;
import com.PBKK.SIPTC.entity.Transaksi;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private TransaksiDAO transaksiDAO;
	
	@Autowired
	private StatusDAO statusDAO;
	
	@GetMapping(value="/login")
	public String loginPageAdmin() {
		return "login_admin2";
	}
	
	public String registerPageAdmin() 
	{
		return "register_admin";
	}
	
	@GetMapping(value="/coba")
	public String coba()
	{
		return "print_form";
	}
	
	@GetMapping(value="/dashboard")
	public String dashboardAdmin(HttpSession session, Model model) 
	{
		Admin admin;
		try {
			admin = (Admin)session.getAttribute("admin_data");
			if (admin == null) {
				return "redirect:/admin/login";
			}
		}
		catch (Exception e) {
			System.out.println(e);
			return "redirect:/admin/login";
		}
		
		List<Transaksi> allTransaksi = transaksiDAO.getAllTransaksi();
		
		if (allTransaksi.size() == 0) {
			model.addAttribute("no_data", true);
		}
		else
			model.addAttribute("allTransaksi", allTransaksi);
			
		return "dashboard_admin";
	}
	
	// Proses transaksi oleh admin
	@GetMapping(value="/transaksi")
	public String prosesTransaksi(@RequestParam("transaksi_id")int id,
			HttpSession session,
			Model model)
	{
		Transaksi theTransaksi = transaksiDAO.getTransaksi(id);
		List<Status> statuses = statusDAO.getAllStatus();
		
		model.addAttribute("transaksi", theTransaksi);
		model.addAttribute("statuses", statuses);
		return "update_transaksi";
	}
	
	@PostMapping(value="/updatetransaksi")
	public String updateTransaksi(@ModelAttribute("transaksi") Transaksi theTransaksi)
	{
		transaksiDAO.updateTransaksi(theTransaksi);
		return "redirect:/admin/dashboard";
	}
	
	@GetMapping("/delete")
	public String deleteTransaksi(@RequestParam("transaksi_id")int id)
	{
		transaksiDAO.deleteTransaksi(id);
		return "redirect:/admin/dashboard";
	}
	// End of proses transaksi oleh admin
	
	@PostMapping(value="/processlogin")
	public String processLogin(HttpServletRequest request, 
			HttpSession session,
			ModelMap model) 
	{
		String return_page = "redirect:/admin/login";
		String nrp_admin = request.getParameter("nrp_admin");
		String password = request.getParameter("password");
		Admin admin_data = adminDAO.getAdmin(nrp_admin, password);
		
		try {
			session.setAttribute("admin_data", admin_data);
			return_page = "redirect:/admin/dashboard";
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return return_page;
	}
//	@PostMapping(value="/processlogin")
//	public String processLogin(HttpServletRequest request, 
//			Model model) 
//	{
//		String return_page = "redirect:/admin/login";
//		String nrp_admin = request.getParameter("nrp_admin");
//		String password = request.getParameter("password");
//		Admin admin_data = adminDAO.getAdmin(nrp_admin, password);
//		
//		try {
//			setAdminSession(request, admin_data);
//			return_page = "redirect:/admin/dashboard";
//		}
//		catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		return return_page;
//	}
	
	@RequestMapping(value="/logout")
	public String logout_admin(HttpServletRequest request) 
	{
		request.getSession().invalidate();
		return "redirect:/admin/login";
	}
	
//	@RequestMapping("/testproc")
//	public String testProc(Model model)
//	{
//		String nrp_admin = "05111540000080";
//		String password = "yoga";
//		
//		SessionFactory factory = new Configuration()
//				.configure("hibernate.cfg.xml")
//				.addAnnotatedClass(Admin.class)
//				.buildSessionFactory();
//		Session session = factory.getCurrentSession();
//		session.beginTransaction();
//		
//		String hql_get = "FROM " + Admin.class.getName() + " a WHERE a.nrp_admin = :username AND a.password = :password";
//		Query query = session.createQuery(hql_get);
//		query.setParameter("username", nrp_admin);
//		query.setParameter("password", password);
//		List<Admin> admin = query.list();
//		
//		model.addAttribute("Nama", admin.get(0).getNama_admin());
//		model.addAttribute("Nrp", admin.get(0).getNrp_admin());
//		model.addAttribute("Email_admin", admin.get(0).getEmail_admin());
//		
//		return "test";
//	}
}
