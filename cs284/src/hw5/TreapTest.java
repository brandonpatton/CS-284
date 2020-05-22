package hw5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreapTest {
	@Test
	public void test1() {
		Treap test = new Treap();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(3,0);
		assertEquals(test.find(0),false);
		assertEquals(test.find(2),true);
		}
	@Test
	public void test2() {
		Treap test = new Treap();
		test.add(1);
		test.add(2);
		test.add(3);
		test.delete(1);
		assertEquals(test.find(1), false);
		assertEquals(test.find(9), false);
	}
	@Test
	public void test3() {
		Treap test = new Treap();
		test.add(2);
		test.add(3);
		test.delete(2);
		assertEquals(test.find(2), false);
		assertEquals(test.find(3), true);
	}
}
