package net.coolblossom.lycee.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.coolblossom.lycee.app.web.entity.Book;
import net.coolblossom.lycee.app.web.enums.RetValues;
import net.coolblossom.lycee.app.web.form.SearchBookForm;
import net.coolblossom.lycee.app.web.service.BookService;

@Controller
@RequestMapping("search")
public class SearchBookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("")
	public String index(@Validated SearchBookForm form, Model model) {
		List<Book> list = bookService.select(form.getKeyword());

		model.addAttribute("bookList", list);
		model.addAttribute("keyword", form.getKeyword());

		return "searchbook/index";
	}


	@RequestMapping("detail/{bookId}")
	public String detail(@PathVariable(name="bookId") String bookId, Model model) {
		Optional<Book> book = bookService.selectById(Integer.valueOf(bookId));

		if (!book.isPresent()) {
			return "redirect:/search";
		}

		model.addAttribute("bookInfo", book.get());
		model.addAttribute("retValue", RetValues.TO_BOOKDETAIL);
		return "searchbook/detail";
	}



}
