package application;

import java.util.ArrayList;
import java.util.List;

import datastructure.Heap;

public class Main2 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();

		l.add("2");
		l.add("5");
		l.add("1");
		l.add("4");
		l.add("89");
		l.add("2");
		l.add("432");
		l.add("11");
		l.add("98");

		List<String> a = Heap.heapSort(l);
		System.out.println(a);

	}

}
