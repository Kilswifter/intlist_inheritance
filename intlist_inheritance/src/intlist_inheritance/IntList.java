package intlist_inheritance;

import java.util.Arrays;

/**
 * Each instance of this class stores a sequence of {@code int} values.
 */
public abstract class IntList {
	
	/**
	 * Returns the sequence of values stored by this object.
	 * 
	 * @post | result != null
	 */
	abstract int[] getElements();
	
	/**
	 * Returns the number of elements of the sequence of values stored by this object.
	 * 
	 * @post | result == getElements().length
	 */
	abstract int getSize();
	
	/**
	 * Returns the element at the given index in the sequence of values stored by this object.
	 * 
	 * @throws IllegalArgumentException if the given index is out of bounds
	 *    | index < 0 || getSize() <= index
	 * 
	 * @post | result == getElements()[index]
	 */
	abstract int getElementAt(int index);
	
	/**
	 * Inserts the given element at the given index in the sequence of values stored by this object.
	 * 
	 * @throws IllegalArgumentException if the given index is out of bounds
	 *    | index < 0 || getSize() < index
	 * 
	 * @mutates | this
	 * 
	 * @post | getSize() == old(getSize()) + 1
	 * @post | getElementAt(index) == element
	 * @post | Arrays.equals(getElements(), 0, index, old(getElements()), 0, index)
	 * @post | Arrays.equals(getElements(), index + 1, getSize(), old(getElements()), index, old(getSize()))
	 */
	abstract void insert(int index, int element);

	/**
	 * Removes the element at the given index in the sequence of values stored by this object.
	 *  
	 * @throws IllegalArgumentException if the given index is out of bounds
	 *    | index < 0 || getSize() <= index
	 * 
	 * @mutates | this
	 * 
	 * @post | getSize() == old(getSize()) - 1
	 * @post | Arrays.equals(getElements(), 0, index, old(getElements()), 0, index)
	 * @post | Arrays.equals(getElements(), index, getSize(), old(getElements()), index + 1, old(getSize()))
	 */
	abstract void removeAt(int index);

}
