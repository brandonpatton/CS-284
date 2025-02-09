package hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class hw1Test {

	@Test
	public void test() {
		BinaryNumber b1 = new BinaryNumber("101");
		assertEquals(b1.toString(),"101");
		assertEquals(b1.getLength(),3);
		assertEquals(b1.getDigit(1),0);
		assertEquals(b1.toDecimal(),5);
		BinaryNumber b2 = new BinaryNumber("010");
		b1.add(b2);
		assertEquals(b1.toString(), "111");
		
		//Examples of test cases that should cause JUnit to fail:
		//BinaryNumber b3 = new BinaryNumber("011");
		//assertEquals(b3.toString(), "101");
		//assertEquals(b3.toDecimal(),72);
		
	}

}
