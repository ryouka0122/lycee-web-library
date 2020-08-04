package net.coolblossom.lycee.app.web.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.coolblossom.lycee.app.web.entity.User;
import net.coolblossom.lycee.app.web.repository.UserRepository;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	private UserRepository userRepository;


	@RequestMapping("")
	@Transactional
	public String show(Model model) {
		List<User> list = userRepository.findAll();
		model.addAttribute("userList", list);

		return "account/show.html";
	}



}
