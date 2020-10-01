package test;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.Stack;

public class StackTest {

	private Stack<String> stack;

	public void setup() {
		stack = new Stack<String>();
	}

	public void setup1() {
		stack = new Stack<String>();
		stack.push("David Fiat");
		stack.push("David Restrepo");
		stack.push("Jhoan Fiat");
	}

	@Test
	public void top() {
		setup1();
		String s = stack.top();
		assertTrue(s != null);
		setup1();
		assertFalse(stack.isEmpty());
		s = stack.top();
		assertTrue(s.equals("Jhoan Fiat"));
	}

	@Test
	public void pop() {
		setup();
		String s = stack.pop();
		assertTrue(s == null);
		assertTrue(stack.isEmpty());

	}

	@Test
	public void pushPop() {
		setup1();
		String s = "Camila Giraldo";
		stack.push(s);
		assertTrue(stack.pop().equals("Camila Giraldo"));
		assertTrue(stack.size() == 3);
		assertTrue(stack.pop().equals("Jhoan Fiat"));
		assertTrue(stack.size() == 2);
		s = "Jhoan Fiat";
		stack.push(s);
		assertTrue(stack.size() == 3);
		assertTrue(stack.pop().equals("Jhoan Fiat"));
		assertTrue(stack.size() == 2);
		assertTrue(stack.pop().equals("David Restrepo"));
		assertTrue(stack.size() == 1);
		assertTrue(stack.pop().equals("David Fiat"));
		assertTrue(stack.size() == 0);

	}

}
