package src;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {10, 20, 30, 40, 50};
	        int target = 30;
	        
	        int result = linearSearch(arr, target);
	        
	        if (result == -1) {
	            System.out.println("Element not found in the array.");
	        } else {
	            System.out.println("Element found at index: " + result);
	        }
	    }

	    public static int linearSearch(int[] arr, int target) {
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] == target) {
	                return i; // Return the index if the target is found
	            }
	        }
	        return -1; // Return -1 if the target is not found
	    }
	}


