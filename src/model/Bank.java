package model;

import java.util.List;

import datastructure.*;

public class Bank {

	private IQueue<Client> clientsQueue;
	private IHashTable<String, Client> clients;
	private IHeap<Client> priorityQueue;

	public Bank() {
		clientsQueue = new Queue<Client>();
		clients = new HashTable<String, Client>();
		priorityQueue = new Heap<Client>();

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
