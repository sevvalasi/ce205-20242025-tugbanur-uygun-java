package com.sevval.tugba.naz.irem.market;
import static java.lang.System.out;

public class Queue {
    private QueueNode front; // Front of the queue
    private QueueNode rear; // Rear of the queue

    // Constructor
    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Check if the queue is empty
    public boolean isQueueEmpty() {
        return front == null;
    }

    // Add a vendor to the queue
    public void enqueue(Vendor vendor) {
        QueueNode newNode = new QueueNode(vendor);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Remove a vendor from the queue
    public Vendor dequeue() {
        if (isQueueEmpty()) {
            out.println("Queue is empty.");
            return new Vendor(0, ""); // Return an empty vendor object
        }
        Vendor vendor = front.vendor;
        front = front.next;

        if (front == null) {
            rear = null; // If the queue is empty, reset rear as well
        }
        return vendor;
    }

    // Free all nodes in the queue
    public void freeQueue() {
        while (!isQueueEmpty()) {
            dequeue();
        }
    }

	public void add(Vendor vendor) {
		// TODO Auto-generated method stub
		
	}

	public Vendor poll() {
		// TODO Auto-generated method stub
		return null;
	}
}

class QueueNode {
    public Vendor vendor; // Vendor object
    public QueueNode next; // Pointer to the next node

    // Constructor
    public QueueNode(Vendor vendor) {
        this.vendor = vendor;
        this.next = null;
    }
}

