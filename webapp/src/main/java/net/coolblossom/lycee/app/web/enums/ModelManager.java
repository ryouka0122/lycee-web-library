package net.coolblossom.lycee.app.web.enums;

public enum ModelManager {
	SIGNUP("signup"),
	BOOK("book"),
	AUTHOR("author"),
	PUBLISHER("publisher")
	;

	private String pattern;

	private ModelManager(String pattern) {
		this.pattern = pattern;
	}

	public boolean match(String source) {
		return pattern.equals(source);
	}

}
