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
@Table(name="publishers")
public class Publisher {

	@Id
	@Column(name = "publisher_id")
	private Integer publisherId;

	@Column(name = "publisher_name")
	private String publisherName;

	@OneToMany(mappedBy = "publisher")
	private List<Book> book;

}
