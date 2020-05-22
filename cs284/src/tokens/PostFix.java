package tokens;

import java.util.ArrayList;
import java.util.List;
import tokens.*;

public class PostFix {
	private List<Token> tokens;
	private StackSLL<Token> stack;

	public PostFix(List<Token> ts) {
		tokens = ts;
		stack = new StackSLL<Token>();
	}

	private Token_Num eval_operator(Token op, Token_Num left_operand, Token_Num right_operand) {
		switch (((Token_Op) op).getData()) {
		case '+':
			return new Token_Num(left_operand.getData() + right_operand.getData());
		case '-':
			return new Token_Num(left_operand.getData() - right_operand.getData());
		default:
			throw new IllegalArgumentException();
		}
	}

	public Integer eval() {
		for (Token t : tokens) {
			if (t.isNumber()) {
				stack.push(t);
			} else {
				Token right_operand = stack.pop();
				Token left_operand = stack.pop();
				stack.push(eval_operator(t, (Token_Num) left_operand, (Token_Num) right_operand));
			}
		}
		return ((Token_Num) stack.pop()).getData();
	}

	public static void main(String[] args) {
		List<Token> ts = new ArrayList<Token>();
		ts.add(new Token_Num(4));
		ts.add(new Token_Num(4));
		ts.add(new Token_Op('+'));
		ts.add(new Token_Num(5));
		ts.add(new Token_Op('-'));
		PostFix p = new PostFix(ts);
		System.out.println(p.eval());
	}
}
