package hw3;

import static org.junit.Assert.*;

import org.junit.Test;

public class IDLListTest {

	@Test
	public void test1() {
		//Testing add(index, elem)
		int elements = 7;
		IDLList s = new IDLList();
		for(int i = 10; i < elements + 10; i++) {
			s.append(i);
		}
		int Target = (s.size()%2);
		int var = 99;
		
		Object First = s.get(Target);
		s.add(Target, var);
		Object Second = s.get(Target+1);
		assertEquals(First, Second);
		assertEquals(s.get(Target), var);
	}
	@Test
	public void test2(){
		//Testing add(elem)
		IDLList s = new IDLList();
		int elements = 7;
		for(int i = 10; i < elements+10; i++) {
			s.append(i);
		}
		
		int Target = (s.size()%2);
		int var = 99;
		Object First = s.get(0);
		Object Last = s.get(s.size()-1);
		Object Tar = s.get(Target);
		s.add(var);
		Object Second = s.get(1);
		Object newLast = s.get(s.size()-1);
		Object newTar = s.get(Target+1);
		assertEquals(Last, newLast);	
		assertEquals(First, Second);
		assertEquals(Tar, newTar);
		assertNotEquals(Tar, s.get(Target));
		
	}
	
	@Test
	public void test3() {
		//Testing append
		IDLList s = new IDLList();
		int elements = 7;
		for(int i = 10; i <= elements+10; i++) {
			s.add(i);
		}
		int Target = (s.size()%2);
		Object Last = s.get(s.size()-1);
		Object Head = s.get(0);
		Object Tar = s.get(Target);
		s.append(elements+11);
		Object newLast = s.get(s.size()-1);
		Object newHead = s.get(0);
		Object newTar = s.get(Target);
		assertEquals(Head, newHead);
		assertEquals(Tar, newTar);
		assertNotEquals(Last, newLast);
			
	}
	
	@Test
	public void test4() {
		//Testing get
		IDLList s = new IDLList();
		int elements = 7;
		for(int i = 10; i <= elements+10; i++) {
			s.append(i);
		}
		int Target = (s.size()%2);
		
		Object FirstGetter = s.get(0);
		Object SecondGetter = s.get(1);
		Object LastGetter = s.get(s.size()-1);
		Object added = s.add(Target, elements+11);
		Object addedTest = s.get(Target);
		
		assertEquals(FirstGetter, 10);
		assertEquals(SecondGetter, 11);
		assertEquals(LastGetter, 17);
		assertEquals(addedTest, 18);
		assertNotEquals(FirstGetter, SecondGetter);
		
	}
	
	@Test
	public void test5() {
		//Testing getHead
		IDLList s = new IDLList();
		int elements = 7;
		for(int i = 10; i <= elements+10; i++) {
			s.append(i);
		}

		Object Head = s.get(0);
		Object newHead = s.getHead();
		s.add(9);
		Object addHead = s.getHead();
		Object addHeadTest = s.get(0);
		assertEquals(Head, newHead);
		assertEquals(addHead, addHeadTest);
	}
	
	@Test
	public void test6() {
		//Testing getLast
		IDLList s = new IDLList();
		int elements = 7;
		for(int i = 10; i <= elements+10; i++) {
			s.append(i);
		}
		
		Object Last = s.getLast();
		Object newLast = s.get(s.size()-1);
		s.append(elements + 11);
		Object LastTest = s.getLast();
		Object newLastTest = s.get(s.size()-1);
		assertEquals(LastTest, newLastTest);		
		assertEquals(Last, newLast);
		assertNotEquals(Last, newLastTest);
	}
	
	@Test
	public void test7() {
		//Testing size
		IDLList s = new IDLList();
		int elements = 7;
		for(int i = 10; i < elements+10; i++) {
			s.append(i);
		}
		
		Object magnitude = s.size();
		assertEquals(elements, magnitude);
		s.add(elements+10);
		Object newMagnitude = s.size();
		assertEquals(elements+1, newMagnitude);
	}
	
	@Test
	public void test8() {
		//Testing remove
		IDLList s = new IDLList();
		int elements = 7;
		for(int i = 10; i <= elements+10; i++) {
			s.append(i);
		}
		
		Object afterHead = s.get(1);
		Object magnitude = s.size()-1;
		s.remove();
		Object newHead = s.get(0);
		Object newMagnitude = s.size();
		assertEquals(afterHead, newHead);
		assertEquals(magnitude, newMagnitude);
	}
	
	@Test
	public void test9() {
		//Testing removeLast
		IDLList s = new IDLList();
		int elements = 7;
		for(int i = 10; i <= elements+10; i++) {
			s.append(i);
		}
		
		Object Last = s.getLast();
		Object preLast = s.get(s.size()-2);
		Object magnitude = s.size()-1;
		s.removeLast();
		Object newLast = s.getLast();
		Object newMagnitude = s.size();
		assertEquals(preLast, newLast);
		assertEquals(magnitude, newMagnitude);
	}

	@Test
	public void test10() {
		//Testing removeAt
		IDLList s = new IDLList();
		int elements = 7;
		for(int i = 10; i <= elements+10; i++) {
			s.append(i);
		}
		
		int Target = (s.size()%2);
		Object testElem = s.get(Target);
		Object magnitude = s.size()-1;
		s.removeAt(Target+1);
		Object newTestElem = s.get(Target);
		Object newMagnitude = s.size();
		assertEquals(testElem, newTestElem);
		assertEquals(magnitude, newMagnitude);
	}
	
	@Test
	public void test11() {
		//Testing boolean remove
		IDLList s = new IDLList();
		int elements = 7;
		for(int i = 10; i <= elements+10; i++) {
			s.append(i);
		}
		
		int Target = s.size()%2;
		Object magnitude = s.size()-1;
		Object TBR = s.get(Target);
		boolean tester = s.remove(TBR);
		Object newMagnitude = s.size();
		assertEquals(magnitude, newMagnitude);
		assertEquals(tester, true);
		
	}
	
	@Test
	public void test12() {
		IDLList s = new IDLList();
		int elements = 7;
		for(int i = 10; i <= elements+10; i++) {
			s.append(i);
		}
		
		assertEquals(s.toString(), "Head --> [10] <--> [11] <--> [12] <--> [13] <--> [14] <--> [15] <--> [16] <--> [17] <-- Tail");
		s.append(elements+11);
		assertEquals(s.toString(), "Head --> [10] <--> [11] <--> [12] <--> [13] <--> [14] <--> [15] <--> [16] <--> [17] <--> [18] <-- Tail");
	}

}
