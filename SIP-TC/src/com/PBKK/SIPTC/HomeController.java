package com.PBKK.SIPTC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHome()
	{
		return "menu";
	}
	
	@RequestMapping("/pesan")
	public String showPesan()
	{
		return "print";
	}
}
