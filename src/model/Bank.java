package model;

import java.util.List;

import customExceptions.RepeatedElementException;
import datastructure.*;

public class Bank {

	private IQueue<Client> clientsQueue;
	private IHashTable<String, Client> clients;
	private IHashTable<String, Client> deserters;
	private IHeap<Client> priorityQueue;

	public Bank() {
		clientsQueue = new Queue<Client>();
		priorityQueue = new Heap<Client>();
		clients = new HashTable<String, Client>();
		deserters = new HashTable<String, Client>();

	}

	public void addGeneralQueue(Client c) {
		clientsQueue.enqueue(c);
	}

	public void addPriorityQueue(Client c) {
		priorityQueue.insert(c);
	}

	public void addDataBase(String ID, Client client) throws RepeatedElementException {
		clients.add(ID, client);
	}

	public void deleted(String ID) throws RepeatedElementException {
		Client deserter = clients.delete(ID);
		deserters.add(ID, deserter);

	}

	public Client searchC(String ID) {
		return clients.search(ID);
	}

	public Client searchDeserterC(String ID) {
		return deserters.search(ID);
	}

	public void attend() {
		priorityQueue.attend();
	}

	public IQueue<Client> getClientsQueue() {
		return clientsQueue;
	}

	public void setClientsQueue(IQueue<Client> clientsQueue) {
		this.clientsQueue = clientsQueue;
	}

	public IHashTable<String, Client> getClients() {
		return clients;
	}

	public void setClients(IHashTable<String, Client> clients) {
		this.clients = clients;
	}

	public IHashTable<String, Client> getDeserters() {
		return deserters;
	}

	public void setDeserters(IHashTable<String, Client> deserters) {
		this.deserters = deserters;
	}

	public IHeap<Client> getPriorityQueue() {
		return priorityQueue;
	}

	public void setPriorityQueue(IHeap<Client> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

	public List<Client> returnClientListByName() {
		List<Client> l = clients.returnHash();
		Heap.heapSort(l);
		return l;

	}

	public List<Client> returnClientListByID() {
		List<Client> l = clients.returnHash();
		for (int i = 0; i < l.size(); i++) {
			for (int i2 = 0; i2 < l.size() - 1 - i; i2++) {
				if (l.get(i2).compareById(l.get(i2 + 1)) > 0) {

					Client temp = l.get(i2);
					l.set(i2, l.get(i2 + 1));
					l.set(i2 + 1, temp);

				}
			}
		}
		return l;

	}

}
