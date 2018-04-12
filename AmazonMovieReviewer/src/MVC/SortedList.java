package MVC;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The SortedList sorts an ArrayList as items are being added to it.
 * @author shafeeq
 *
 * @param <E>
 */
public class SortedList<E extends Comparable<E>> implements Iterable<E> {

	private ArrayList<E> arraylist = new ArrayList<E>();
	
	//Swap items at indexes a and b
	private void swap(int a, int b) {
		E temp = arraylist.get(a);
		arraylist.set(a, arraylist.get(b));
		arraylist.set(b, temp);
	}

	/**
	 * Return the ArrayList object
	 * @return
	 */
	public ArrayList<E> getArraylist() {
		return arraylist;
	}

	
	/**
	 * Add an item and then sort it.
	 * @param e
	 */
	public void addSortItem(E e) {

		arraylist.add(e);
		if (arraylist.size() < 2)
			return;

		int size = arraylist.size();

		for (int i = size - 1; i > 0; i--) {
			if (arraylist.get(i).compareTo(arraylist.get(i - 1)) < 0) {
				swap(i, i - 1);

			}

		}

	}
	
	/**
	 * Returns the size of the ArrayList
	 * @return
	 */
	public int size() {
		return arraylist.size();
	}

	/**
	 * Gets Element E at index i.
	 * @param i
	 * @return
	 */
	public E get(int i) {
		return arraylist.get(i);
	}

	/**
	 * Returns the iterator of the ArrayList.
	 */
	@Override
	public Iterator<E> iterator() {
		return arraylist.iterator();
	}

}
