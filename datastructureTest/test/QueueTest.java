package test;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.Queue;

public class QueueTest {

	private Queue<String> queue;

	public void setup1() {
		queue = new Queue<String>();
	}

	public void setup2() {
		queue = new Queue<String>();
		queue.enqueue("Juan Manuel");
	}

	public void setup3() {
		queue = new Queue<String>();
		queue.enqueue("David Fiat");
		queue.enqueue("Juan Reyes");
		queue.enqueue("Linus Torvalds");

	}

	@Test
	public void front() {
		setup1();
		String s = queue.front();
		assertTrue(s == null);
	}

	@Test
	public void front2() {
		setup2();
		String s = queue.front();
		assertTrue(s.equals("Juan Manuel"));
		String s2 = queue.front();
		assertFalse(s2.equals("Maria"));
	}

	@Test
	public void enqueue() {
		setup1();
		String s = "Davif Fiat";
		queue.enqueue(s);
		assertTrue(queue.front().equalsIgnoreCase(s));

	}

	@Test
	public void enqueuDequeue() {
		setup3();
		String s = "Michael Jackson";
		String s1 = "Maria Alejandra";
		String s2 = "Camila Giraldo";
		queue.enqueue(s);
		assertFalse(queue.front().equalsIgnoreCase(s));
		assertTrue(queue.dequeue().equalsIgnoreCase("David Fiat"));
		assertTrue(queue.dequeue().equalsIgnoreCase("Juan Reyes"));
		queue.enqueue(s2);
		assertTrue(queue.dequeue().equalsIgnoreCase("Linus Torvalds"));
		assertTrue(queue.dequeue().equalsIgnoreCase("Michael Jackson"));
		queue.enqueue(s1);
		assertTrue(queue.dequeue().equalsIgnoreCase("Camila Giraldo"));
		assertTrue(queue.dequeue().equalsIgnoreCase("Maria Alejandra"));

	}

}
