
public class Search {
	/**
	 * @author David
	 * @param arr - input array of objects
	 * @param lo - lower bound of search
	 * @param hi - upper bound of search
	 * @param target - target object
	 * @return - array index of target object, -1 if not found
	 */
	public static int binarySearch(Comparable[] arr, int lo, int hi, Comparable target) {
		int mid;
		if (lo < hi) {
			
			mid = (lo + hi)/2;
			
			if ((target.compareTo(arr[mid])) < 0) {
				return binarySearch(arr,mid+1,hi,target);
				
			} else if (target.compareTo(arr[mid]) > 0) {
				return binarySearch(arr,lo,mid-1,target);
				
			}
			return mid; //target found
		}
		return -1; //target not found
	}
}
