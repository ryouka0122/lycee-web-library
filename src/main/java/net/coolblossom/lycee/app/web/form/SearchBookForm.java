package net.coolblossom.lycee.app.web.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class SearchBookForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String keyword;

}
