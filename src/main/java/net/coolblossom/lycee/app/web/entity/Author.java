package net.coolblossom.lycee.app.web.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="authors")
public class Author {

	@Id
	@Column(name = "author_id")
	private Integer authorId;

	@Column(name = "author_name")
	private String authorName;

	@OneToMany(mappedBy = "author")
	private List<Book> book;

}
