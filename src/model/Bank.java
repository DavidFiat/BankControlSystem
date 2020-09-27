package model;

import datastructure.*;

public class Bank {

	private IQueue<Client> clientsQueue;
	private IHashTable<String, Client> clients;
	private IHeap<Client> priorityQueue;

	public Bank() {
		clientsQueue = new Queue<>();
		clients = new HashTable<>();
		setPriorityQueue(new Heap<Client>());

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

}
