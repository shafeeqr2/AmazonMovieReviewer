package MVC;

public class Search {
	/**
	 * @author David
	 * @param arr - input array of objects
	 * @param lo - lower bound of search
	 * @param hi - upper bound of search
	 * @param target - target object
	 * @return - array index of target object, -1 if not found
	 */
	
	/**
	 * Carries out binary search on a comparable array. Returns the index if the target exists. Otherwise, it returns -1.
	 * @param arr
	 * @param lo
	 * @param hi
	 * @param target
	 * @return
	 */
	public static int binarySearch(Comparable[] arr, int lo, int hi, Comparable target) {
		int mid;
		if (lo < hi) {
			
			mid = (lo + hi)/2;
			
			if ((target.compareTo(arr[mid])) < 0) {
				return binarySearch(arr,lo,mid,target);
				
			} else if (target.compareTo(arr[mid]) > 0) {
				return binarySearch(arr,mid+1,hi,target);
				
			}
			return mid; //target found
		}
		return -1; //target not found
	}
	
	/**
	 * Carries out binary search on the movies array and returns the index of the target movie if it exists in the array. Otherwise, it returns -1.
	 * @param arr
	 * @param lo
	 * @param hi
	 * @param target
	 * @return
	 */
	public static int binarySearch(SortedList<Movie> arr, int lo, int hi, Movie target) {
		int mid;
		if (lo < hi) {
			
			mid = (lo + hi)/2;

			if (target.compareTo(arr.get(mid)) < 0) {
//				System.out.println(target.getProductID() + " " + arr.get(mid).getProductID() + " " + target.compareTo(arr.get(mid)));
				return binarySearch(arr,lo,mid,target);
				
			} else if (target.compareTo(arr.get(mid)) > 0) {
//				System.out.println(target.getProductID() + " " + arr.get(mid).getProductID() + " " + target.compareTo(arr.get(mid)));
				return binarySearch(arr,mid+1,hi,target);
				
			}
			
			return mid; //target found
		}
		return -1; //target not found
	}
}
