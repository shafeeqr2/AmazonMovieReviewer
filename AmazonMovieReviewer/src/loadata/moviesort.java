package loadata;

public class moviesort {
/**
 * 
 * @param a - array of movie class object
 * @param lo - starting index, to be 0 here 
 * @param hi - ending index, equal to the array size
 */
	public static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	
	private static int partition(Comparable[] a, int lo, int hi)
	{
		int i = lo, j= hi +1;
		Comparable v = a[lo];
		while(true)
		{
			while (a[++i].compareTo(v) < 0) if (i == hi) break;
			while (a[--j].compareTo(v) > 0) if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, hi);
		return j;
	}
	
	
	public static void exch(Comparable[] x, int i, int j) {
		Comparable tmp = x[i];
		x[i] = x[j];
		x[j] = tmp;
	}
	
	public static void main(Comparable[] args) {
		sort(args, 0, args.length);
		
		// TODO Auto-generated method stub

	}

}
