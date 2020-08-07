package net.coolblossom.lycee.app.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;

@Controller
@RequestMapping("/")
public class IndexController {


	@RequestMapping(path="")
	public String index() {
		System.out.println("IndexController#index()");
		return "index";
	}

	@RequestMapping(path="test1")
	public String test1() {
		System.out.println("IndexController#test1()");
		return "test";
	}

	@RequestMapping(path="test2")
	public String test2() {
		System.out.println("IndexController#test2()");
		return "test/index";
	}

	@RequestMapping(path="print/{word}")
	public String print(@PathVariable String word, Model model) {
		String alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println("IndexController#print()");
		System.out.println("word:" + word);

		int cnt = Integer.parseInt(word);
		List<Character> list = Lists.charactersOf(alfa.substring(0, Math.min(26, cnt)));
		model.addAttribute("charList", list);

		return "print";
	}




}
