package lesson02;

public class Solution_2 {

	public static void main(String[] args) {
		int[] arr = {3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 7};
		int result = 0;
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					count++;
				}
			}
			
			if(count % 2 != 0) {
				result = arr[i];
				break;
			}
			
			count = 0;
		}
		
		System.out.println(result);
	}

}
