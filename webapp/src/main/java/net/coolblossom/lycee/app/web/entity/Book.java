package net.coolblossom.lycee.app.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="books")
public class Book {

	@Id
	@Column(name = "book_id")
	private Integer bookId;

	@Column(name = "book_name")
	private String bookName;

	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;

	@ManyToOne
	@JoinColumn(name="publisher_id")
	private Publisher publisher;

}
