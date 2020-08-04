package net.coolblossom.lycee.app.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_name")
	private String userName;

}
