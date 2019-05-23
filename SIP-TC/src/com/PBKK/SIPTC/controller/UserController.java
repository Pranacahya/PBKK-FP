package com.PBKK.SIPTC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.PBKK.SIPTC.dao.TransaksiDAO;
import com.PBKK.SIPTC.entity.Transaksi;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private TransaksiDAO userDAO;
	
	@RequestMapping("/showUser")
	public String showUser(Model myModel)
	{
		return "print";
	}
	@RequestMapping("/formUser")
	public String formUser()
	{
		return "print_form";
	}
	@RequestMapping(value="/prosesUser", method = RequestMethod.POST)
	public String prosesUser(@RequestParam("nama_user") String user,
			@RequestParam("nrp_user") String nrp,
			@RequestParam("file_user") MultipartFile file,
			@RequestParam("copies_user") String copies,
			@RequestParam("pages_user") String pages,
			@RequestParam("color_user") String color,
			@RequestParam("paper_user") String paper,
			@RequestParam("side_user") String side,
			@RequestParam("note_user") String note)
	{	
		userDAO.pushTransaksi(user, nrp, file, copies, pages, color, paper, side, note);
		
		List<Transaksi> transac = userDAO.getAllTransaksi();
		
		return"print_status";
	}
	
	@RequestMapping("/showUser2")
	public String showUser2(Model myModel)
	{
		User myUser = new User();
		
		myModel.addAttribute("User",myUser);
		System.out.print("test");
		return "print_form";
	}
	
	@RequestMapping("/formUser2")
	public String formUser2(Model myModel)
	{
		return "upload";
	}
	
	@RequestMapping("/prosesUser2")
	public String prosesUser2(Model myModel)
	{
		User myUser = new User();
		myModel.addAttribute("User",myUser);
		System.out.print("test");
		return "print_status";
	}

}
