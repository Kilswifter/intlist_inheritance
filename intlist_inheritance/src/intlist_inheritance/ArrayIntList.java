package intlist_inheritance;

import java.util.Arrays;

/**
 * Each instance of this class stores a sequence of {@code int} values.
 */
public class ArrayIntList extends IntList {
	
	/**
	 * @invar | elements != null
	 * @invar | 0 < elements.length
	 * @invar | 0 <= size
	 * @invar | size <= elements.length 
	 * 
	 * @representationObject
	 */
	private int[] elements;
	private int size;
	
	public int[] getElements() {
		return Arrays.copyOf(elements, size);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Performance note: this method's running time is independent of the number of elements.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Performance note: this method's running time is independent of the number of elements.
	 */
	public int getElementAt(int index) {
		if (index < 0 || size <= index)
			throw new IllegalArgumentException("index out of bounds");
		
		return elements[index];
	}
	
	/**
	 * Initializes this object so that it stores an empty sequence of values.
	 * 
	 * @mutates | this
	 * 
	 * @post | getSize() == 0
	 */
	public ArrayIntList() {
		elements = new int[10];
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Performance note: this method's running time is linear in {@code getSize() - index}.
	 */
	public void insert(int index, int value) {
		if (index < 0 || size < index)
			throw new IllegalArgumentException("index out of bounds");
		
		if (size == elements.length)
			System.arraycopy(elements, 0, elements = new int[size * 2], 0, size);
		System.arraycopy(elements, index, elements, index + 1, size - index);
		elements[index] = value;
		size++;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Performance note: this method's running time is linear in {@code getSize() - index}.
	 */
    public void removeAt(int index) {
		if (index < 0 || size <= index)
			throw new IllegalArgumentException("index out of bounds");

		System.arraycopy(elements, index + 1, elements, index, --size - index);
    }
}
