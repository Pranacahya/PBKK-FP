package com.PBKK.SIPTC;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@RequestMapping("/showUser")
	public String showUser(Model myModel)
	{
		User myUser = new User();
		
		myModel.addAttribute("User",myUser);
		System.out.print("test");
		return "print";
	}
	@RequestMapping("/formUser")
	public String formUser()
	{
		return "upload";
	}
	@RequestMapping(value="/prosesUser")
	public String prosesUser(@RequestParam("nameUser") String user,
							@RequestParam("nrpUser") String nrp,
							@RequestParam("file") MultipartFile file)
	{
		//Sent file
		String myPath = System.getProperty("user.dir")+"/upload";
		File dirPath = new File(myPath);
		if (!dirPath.exists()) 
		{
	        dirPath.mkdirs();     
		}
		String myFile = dirPath+"/"+file.getOriginalFilename();
		File filePath = new File(myFile);
		System.out.println(file.getOriginalFilename());
		try {
			file.transferTo(filePath);
			System.out.println("transfered");
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String timeStamp[];
		timeStamp = dateFormat.format(date).split(" ");
		String tanggal = timeStamp[0];
		String time = timeStamp[1];
		System.out.println(file); //2016/11/16 12:08:43
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Transaksi.class)
				.buildSessionFactory();
		// Begin Transaction
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		// Create object
		Transaksi trans = new Transaksi(2,tanggal,time,user,nrp,0);
				
		// Save object to database 
		session.save(trans);
				
		// Commit transaction
		session.getTransaction().commit();
		System.out.println("Committing transaction.");
				
		// Close transaction
		session.close();
		System.out.println("Session closed.");
				
		SessionFactory factory2 = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(PathFile.class)
						.buildSessionFactory();
		
		// Transaksi simpan path
		Session session2 = factory2.getCurrentSession();
		session2.beginTransaction();

		// Create object
		PathFile trans2 = new PathFile(myFile);
		// Save object to database 
		session2.save(trans2);
				
		// Commit transaction
		session2.getTransaction().commit();
		System.out.println("Committing transaction2.");
		
		// Close transaction
		session.close();
		System.out.println("Session closed.");
		
//		uploadPath 
		return"learn";
	}
	
	@RequestMapping("/showUser2")
	public String showUser2(Model myModel)
	{
		User myUser = new User();
		
		myModel.addAttribute("User",myUser);
		System.out.print("test");
		return "print_form";
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
