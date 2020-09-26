package datastructure;

public interface IHashTable<K, V> {
	

	public V search(K key);

	public void add(K key, V value);

	public void delete(K key);


}
