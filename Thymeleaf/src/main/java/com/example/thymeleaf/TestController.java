package com.example.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class TestController {
	@RequestMapping(value = "/wish",method=RequestMethod.GET)
	public String wish(Model model)
	{
		model.addAttribute("message", "i am depressed");
		return "data";
	}
	@GetMapping
	public String CompaniesData(Model model)

}
