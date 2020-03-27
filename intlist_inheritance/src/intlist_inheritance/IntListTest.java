package intlist_inheritance;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class IntListTest {
	
	void testIntList(IntList list) {
		assertEquals(0, list.getSize());
		
		list.insert(0, 7);
		assertEquals(1, list.getSize());
		assertEquals(7, list.getElementAt(0));
		
		list.insert(0, 42);
		assertEquals(2, list.getSize());
		assertEquals(42, list.getElementAt(0));
		assertEquals(7, list.getElementAt(1));
		
		list.removeAt(0);
		assertEquals(1, list.getSize());
		assertEquals(7, list.getElementAt(0));

		list.insert(1, 42);
		assertEquals(2, list.getSize());
		assertEquals(7, list.getElementAt(0));
		assertEquals(42, list.getElementAt(1));

		list.removeAt(1);
		assertEquals(1, list.getSize());
		assertEquals(7, list.getElementAt(0));

		list.removeAt(0);
		assertEquals(0, list.getSize());
	}

	@Test
	void testArrayIntList() {
		testIntList(new ArrayIntList()); 
	}
	
	@Test
	void testLinkedIntList() {
		testIntList(new LinkedIntList());
	}

}
