package net.coolblossom.lycee.app.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.coolblossom.lycee.app.web.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByBookNameLike(String bookName);

}
