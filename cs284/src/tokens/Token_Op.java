package tokens;

public class Token_Op extends Token {
	private Character data;

	public Token_Op(Character op) {
		data = op;
	}

	public Character getData() {
		return data;
	}

	public boolean isNumber() {
		return false;
	}
}