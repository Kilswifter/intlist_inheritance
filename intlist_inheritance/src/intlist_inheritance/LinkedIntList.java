package intlist_inheritance;

import logicalcollections.LogicalFunction;

/**
 * Each instance of this class stores a sequence of {@code int} values.
 */
public class LinkedIntList extends IntList {
	
	private static class Node {
		/**
		 * @invar | next != null
		 * @invar | previous != null
		 * @invar | next.previous == this
		 * @invar | previous.next == this
		 */
		private int value;
		/** @peerObject */
		private Node next;
		/** @peerObject */
		private Node previous;
	}

	/**
	 * @invar | sentinel != null
	 * @invar | 0 <= size
	 * @invar | size == LogicalFunction.<Node, Integer>rec((f, n) -> n == sentinel ? 0 : f.apply(n.next) + 1).apply(sentinel.next)
	 * @representationObject
	 */
	private Node sentinel;
	private int size;
	
	public int[] getElements() {
		int[] elements = new int[size];
		int i = 0;
		for (Node n = sentinel.next; n != sentinel; n = n.next, i++)
			elements[i] = n.value;
		return elements;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Performance note: this method's running time is independent of the number of elements.
	 */
	public int getSize() { return size; }
	
	/**
	 * @pre FSC4J.valid(this)
	 */
	private Node getNodeAt(int index) {
		Node n = sentinel.next;
		if (index <= size / 2)
			for (int i = 0; i < index; i++)
				n = n.next;
		else
			for (int i = size; index <= i; i--)
				n = n.previous;
		return n;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Performance note: this method's running time is linear in the minimum of {@code index} and {@code getSize() - index}.
	 */
	public int getElementAt(int index) {
		if (index < 0 || size <= index)
			throw new IllegalArgumentException("index out of bounds");
		
		return getNodeAt(index).value;
	}
	
	/**
	 * Initializes this object so that it stores an empty sequence of integers.
	 */
	public LinkedIntList() {
		sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Performance note: this method's running time is linear in the minimum of {@code index} and {@code getSize() - index}.
	 */
	public void insert(int index, int value) {
		if (index < 0 || size < index)
			throw new IllegalArgumentException("index out of bounds");

		Node next = getNodeAt(index);
		Node n = new Node();
		n.value = value;
		n.previous = next.previous;
		n.next = next;
		n.previous.next = n;
		n.next.previous = n;
		size++;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Performance note: this method's running time is linear in the minimum of {@code index} and {@code getSize() - index}.
	 */
	public void removeAt(int index) {
		if (index < 0 || size <= index)
			throw new IllegalArgumentException("index out of bounds");
		
		Node n = getNodeAt(index);
		n.previous.next = n.next;
		n.next.previous = n.previous;
		size--;
	}
	
}
