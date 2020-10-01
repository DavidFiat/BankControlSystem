package test;

import static org.junit.Assert.*;

import org.junit.Test;

import customExceptions.RepeatedElementException;
import datastructure.HashTable;

public class HashTableTest {

	private HashTable<String, String> hash;

	public void setup() throws RepeatedElementException {
		hash = new HashTable<String, String>();
		hash.add("a", "David");
		hash.add("c", "Violetta");
		hash.add("e", "Juan");
		hash.add("g", "Taliana");
		hash.add("i", "Sofia");
		hash.add("k", "Pepe");
		hash.add("m", "Carlos");

	}

	@Test
	public void search() throws RepeatedElementException {
		setup();
		assertTrue("David".equalsIgnoreCase(hash.search("a")));
		assertTrue("Violetta".equalsIgnoreCase(hash.search("c")));
		assertTrue("Juan".equalsIgnoreCase(hash.search("e")));
		assertTrue("Taliana".equalsIgnoreCase(hash.search("g")));
		assertTrue("Sofia".equalsIgnoreCase(hash.search("i")));
		assertTrue("Pepe".equalsIgnoreCase(hash.search("k")));
		assertTrue("Carlos".equalsIgnoreCase(hash.search("m")));

	}

	@Test
	public void exception() {
		boolean throwed = false;
		try {
			setup();
		} catch (RepeatedElementException e) {
			fail();
		}
		try {
			hash.add("c", "Violetta");
		} catch (RepeatedElementException e) {
			throwed = true;
		}

		assertTrue(throwed);

	}

	@Test
	public void delete() throws RepeatedElementException {
		setup();
		assertTrue(hash.Size() == 7);
		assertTrue("David".equalsIgnoreCase(hash.delete("a")));
		assertTrue(hash.Size() == 6);
		assertTrue("Violetta".equalsIgnoreCase(hash.delete("c")));
		assertTrue(hash.Size() == 5);
		assertTrue("Juan".equalsIgnoreCase(hash.delete("e")));
		assertTrue(hash.Size() == 4);
		assertTrue("Taliana".equalsIgnoreCase(hash.delete("g")));
		assertTrue(hash.Size() == 3);
		assertTrue("Sofia".equalsIgnoreCase(hash.delete("i")));
		assertTrue(hash.Size() == 2);
		assertTrue("Pepe".equalsIgnoreCase(hash.delete("k")));
		assertTrue(hash.Size() == 1);
		assertTrue("Carlos".equalsIgnoreCase(hash.delete("m")));
		assertTrue(hash.Size() == 0);

	}

}
