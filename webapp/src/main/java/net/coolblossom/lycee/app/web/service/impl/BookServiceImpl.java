package net.coolblossom.lycee.app.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.EscapeCharacter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;

import net.coolblossom.lycee.app.web.entity.Book;
import net.coolblossom.lycee.app.web.repository.BookRepository;
import net.coolblossom.lycee.app.web.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> select(String keyword) {
		if (StringUtils.isEmpty(keyword)) {
			return Lists.newArrayList();
		}

		return bookRepository.findByBookNameLike(sanitize(keyword));
	}

	@Override
	public Optional<Book> selectById(Integer bookId) {
		return bookRepository.findById(bookId);
	}

	private String sanitize(String str) {
		return "%" + EscapeCharacter.DEFAULT.escape(str) + "%";
	}
}
