package model;

import java.util.List;

import customExceptions.RepeatedElementException;
import datastructure.*;

public class Bank {

	private IQueue<Client> clientsQueue;
	private IHashTable<String, Client> clients;
	private IHeap<Client> priorityQueue;

	public Bank() {
		clientsQueue = new Queue<Client>();
		priorityQueue = new Heap<Client>();

		clients = new HashTable<String, Client>();

	}

	public void addGeneralQueue(Client c) {
		clientsQueue.enqueue(c);
	}

	public void addPriorityQueue(Client c) {
		priorityQueue.add(c);
	}

	public void addDataBase(String ID, Client client) throws RepeatedElementException {
		clients.add(ID, client);
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

	public IHeap<Client> getPriorityQueue() {
		return priorityQueue;
	}

	public void setPriorityQueue(IHeap<Client> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

	public List<Client> returnClientListByName() {
		List<Client> l = clients.returnHash();

		return l;

	}

}
