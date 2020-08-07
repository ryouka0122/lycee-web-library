package net.coolblossom.lycee.app.web.service;


import java.util.List;
import java.util.Optional;

import net.coolblossom.lycee.app.web.entity.Book;

public interface BookService {

	List<Book> select(String keyword);

	Optional<Book> selectById(Integer bookId);

}
