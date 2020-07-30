package net.coolblossom.lycee.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.coolblossom.lycee.app.web.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
