package lesson02;

public class Solution_2_3 {

	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2, 3, 3, 3};
		
		int result = 0;
		
		/**
		 * 비트 연산자인 XOR 이용한 방법
		 * 
		 * ^ 비트 연산자는 둘다 ture이거나 둘다 false일 때, 0이되고
		 * 둘이 다르다면 1이 된다.
		 * 
		 * 이것을 응용하여 
		 * 배열의 값들을 비트 연산할 때, 값이 같다면 모두 0이 된다.
		 * 그러므로 비트연산을 통해 매우 빠르게 처리할 수 있다.
		 */
		for(int i : arr) {
			result ^= i;
		}
	
		System.out.println(result);
	}

}
