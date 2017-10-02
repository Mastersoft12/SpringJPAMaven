package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.IPersonaDao;


@Controller
public class HomeController {
	
	@Autowired
    @Qualifier("personaDao")
	IPersonaDao personaDao;

	@RequestMapping( value = "/", method=RequestMethod.GET)
	public String home(){
	 personaDao.buscarPerosna();
	 return "home";
	}

}