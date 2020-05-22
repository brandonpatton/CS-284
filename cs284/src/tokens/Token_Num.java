package tokens;

public class Token_Num extends Token {
	private Integer data;

	public Token_Num(Integer i) {
		data = i;
	}

	public Integer getData() {
		return data;
	}

	public boolean isNumber() {
		return true;
	}
}