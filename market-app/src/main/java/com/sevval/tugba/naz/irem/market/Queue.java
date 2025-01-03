/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of a queue for managing `Vendor` objects.
 */
package com.sevval.tugba.naz.irem.market;
import static java.lang.System.out;


/**
 * @class Queue
 * @brief Represents a queue data structure for managing `Vendor` objects.
 * @details This class provides standard queue operations such as enqueue, dequeue, and checking if the queue is empty.
 *          It uses the `QueueNode` class to store nodes in the queue.
 */
public class Queue {
    private QueueNode front;  ///< Pointer to the front node of the queue.
    private QueueNode rear;   ///< Pointer to the rear node of the queue.

    /**
     * @brief Constructor for the `Queue` class.
     * @details Initializes an empty queue with `front` and `rear` pointers set to `null`.
     */
    public Queue() {
        this.front = null;
        this.rear = null;
    }

    /**
     * @brief Checks if the queue is empty.
     * @return `true` if the queue is empty; otherwise, `false`.
     */
    public boolean isQueueEmpty() {
        return front == null;
    }

    /**
     * @brief Adds a `Vendor` object to the queue.
     * @details Creates a new `QueueNode` containing the provided `Vendor` object and adds it to the rear of the queue.
     * @param vendor The `Vendor` object to add to the queue.
     */
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

    /**
     * @brief Removes a `Vendor` object from the queue.
     * @details Removes the front node from the queue and returns the `Vendor` object stored in it.
     *          If the queue is empty, returns an empty `Vendor` object with ID 0 and an empty name.
     * @return The `Vendor` object stored in the dequeued node.
     */
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

    /**
     * @brief Frees all nodes in the queue.
     * @details Removes all nodes from the queue, making it empty.
     */
    public void freeQueue() {
        while (!isQueueEmpty()) {
            dequeue();
        }
    }

    /**
     * @brief Adds a `Vendor` to the queue (placeholder).
     * @param vendor The `Vendor` to add.
     * @note This method is a placeholder and should be implemented as needed.
     */
	public void add(Vendor vendor) {
		// TODO Auto-generated method stub
		
	}

	/**
     * @brief Polls a `Vendor` from the queue (placeholder).
     * @return The polled `Vendor` object.
     * @note This method is a placeholder and should be implemented as needed.
     */
	public Vendor poll() {
		// TODO Auto-generated method stub
		return null;
	}
}

/**
 * @class QueueNode
 * @brief Represents a node in the queue.
 * @details This class is used to create nodes for a queue data structure, where each node contains a `Vendor` object and a pointer to the next node.
 */
class QueueNode {
    public Vendor vendor;  ///< The vendor object stored in this node.
    public QueueNode next; ///< Pointer to the next node in the queue.

    /**
     * @brief Constructor for the `QueueNode` class.
     * @details Initializes a queue node with the provided `Vendor` object. 
     *          The `next` pointer is initialized to `null`.
     * @param vendor The `Vendor` object to be stored in this node.
     */
    public QueueNode(Vendor vendor) {
        this.vendor = vendor;
        this.next = null;
    }
}

