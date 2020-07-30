package net.coolblossom.lycee.app.web.enums;

public enum RetValues {
	TO_BOOKDETAIL("bookdetail")
	;

	String ret;

	private RetValues(String val) {
		ret = val;
	}

	@Override
	public String toString() {
		return ret;
	}
}
