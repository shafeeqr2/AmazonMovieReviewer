package loadata;

import java.util.ArrayList;
import java.util.Iterator;

public class SortedList<E extends Comparable<E>>  implements Iterable<E> {

	private ArrayList<E> arraylist = new ArrayList<E>();

	private void swap(int a, int b) {
		E temp = arraylist.get(a);
		arraylist.set(a, arraylist.get(b));
		arraylist.set(b, temp);
	}

	public ArrayList<E> getArraylist() {
		return arraylist;
	}

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

	@Override
	public Iterator<E> iterator() {
		return arraylist.iterator();
	}

}
