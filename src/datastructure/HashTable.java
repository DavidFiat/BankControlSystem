package datastructure;

import java.util.ArrayList;
import java.util.List;

import exception.RepeatedElementException;

public class HashTable<K, V> implements IHashTable<K, V> {

	public static final int SIZE = 1009;
	private HashTableNode<K, V>[] hashTableNodes;

	@SuppressWarnings("unchecked")
	public HashTable() {
		hashTableNodes = new HashTableNode[SIZE];
	}

	@Override
	public V search(K key) {
		V value = null;
		int i = key.hashCode() % SIZE;
		HashTableNode<K, V> h = hashTableNodes[i];
		if (h != null) {
			boolean founded = false;
			while (!founded && h != null) {
				if (h.getKey().equals(key)) {
					value = h.getValue();
					founded = true;
				}
				h = h.getNext();

			}
		}
		return value;
	}

	@Override
	public void add(K key, V value) throws RepeatedElementException {
		int i = key.hashCode() % SIZE;
		HashTableNode<K, V> h = hashTableNodes[i];
		if (h == null) {
			h = new HashTableNode<>(key, value);
			hashTableNodes[i] = h;
		} else {
			if (search(key) != null) {
				String b = (String) search(key);
				throw new RepeatedElementException();
			}
			HashTableNode<K, V> h1 = new HashTableNode<>(key, value);
			h1.setNext(h);
			h.setPrev(h1);
			hashTableNodes[i] = h1;

		}
	}

	@Override
	public V delete(K key) {
		V value = null;
		int i = key.hashCode() % SIZE;
		HashTableNode<K, V> h = hashTableNodes[i];
		if (h != null) {
			boolean deleted = false;
			while (!deleted && h != null) {
				if (h.getKey().equals(key)) {
					value = h.getValue();
					if (h.getNext() != null) {
						h.getNext().setPrev(h.getPrev());

					}
					if (h.getPrev() != null) {
						h.getPrev().setNext(h.getNext());
					}

					deleted = true;
				}
				h = h.getNext();

			}
		}
		return value;

	}

	public HashTableNode<K, V>[] getHashTableNodes() {
		return hashTableNodes;
	}

	public List<V> returnHash() {
		List<V> l = new ArrayList<>();
		for (int i = 0; i < hashTableNodes.length; i++) {
			HashTableNode<K, V> h = hashTableNodes[i];
			while (h != null) {
				l.add(h.getValue());
				h = h.getNext();
			}

		}

		return l;

	}

}
