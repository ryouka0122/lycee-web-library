package net.coolblossom.lycee.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.coolblossom.lycee.app.web.enums.ModelManager;

@Controller
public class CrudController {


	@RequestMapping("/{model}/register")
	public String register(@PathVariable("model") ModelManager manager, Model model) {
		return manager.name().toLowerCase() + "/register";
	}



}

