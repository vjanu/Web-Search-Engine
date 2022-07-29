import java.util.List;

public class SortSearching {
	
	public static void main(String[] args) {
		
		String[] str = { "xa", "Ac", "ac", "12xa" };
		String[] merge = mergeSort(str, 0, str.length - 1);
	    for (int i = 0; i < merge.length; i++) {
	        System.out.println(merge[i]);
	    }
	    
		/*
		 * var words = List.of("sky", "cloud", "atom", "club", "carpet", "wood",
		 * "water", "silk", "bike", "falcon", "owl", "mars");
		 * 
		 * var sorted = words.stream().sorted().toList(); System.out.println(sorted);
		 */
	}

	private static String[] mergeSort(String[] str, int low, int high) {
		 if (low == high) {
	            String[] A = { str[low] };
	            return A;
	        }
	        int mid = low + (high - low) / 2;
	        String[] arr1 = mergeSort(str, low, mid);
	        String[] arr2 = mergeSort(str, mid + 1, high);
	 
	        String[] arr3 = merge(arr1, arr2);
	        return arr3;
	}

	private static String[] merge(String[] arr1, String[] arr2) {
		int m = arr1.length;
        int n = arr2.length;
        String[] arr3 = new String[m + n];
 
        int index = 0;
        int i = 0;
        int j = 0;
 
        while (i < m && j < n) {
            if (isAlphabeticallySmaller(arr1[i], arr2[j])) {
                arr3[index] = arr1[i];
                i++;
                index++;
            }
            else {
                arr3[index] = arr2[j];
                j++;
                index++;
            }
        }
        while (i < m) {
            arr3[index] = arr1[i];
            i++;
            index++;
        }
        while (j < n) {
            arr3[index] = arr2[j];
            j++;
            index++;
        }
        return arr3;
	}

	private static boolean isAlphabeticallySmaller(String string1, String string2) {
		string1 = string1.toUpperCase();
		string2 = string2.toUpperCase();
        if (string1.compareTo(string2) < 0) {
            return true;
        }
        return false;
	}
}
