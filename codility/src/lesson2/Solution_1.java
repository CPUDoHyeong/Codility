package lesson2;

public class Solution_1 {
	/**
	 * 문제
	 * solution 함수는 배열과 숫자를 받아서
	 * 함수의 값들을 숫자만큼 오른쪽으로 이동시키는 것이다
	 * 
	 * 예를들어 [1, 2, 3, 4] 라는 배열과 1을 solution함수에 넣었을 때
	 * 이 함수는 [4, 1, 2, 3]을 반환한다.
	 * 
	 * 이 때 solution 함수의 내용을 작성하시오.
	 * 
	 * 아래와 같은 방법은 답은 나오나
	 * 배열이 길어질수록 시간복잡도가 커지는 단점이 있다.
	 * 즉 효율성은 부족.
	 * 
	 */
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4};
		int loop = 5;
		
		
		input = solution(input, loop);
		
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static int[] solution(int[] A, int K) {
		
		for(int i = 0; i < K; i++) {
			int tmp = 0;
			int tmp2 = 0;
			
			for(int j = 0; j < A.length; j++) {
				if(j == 0) {
					tmp = A[A.length - 1];
					tmp2 = A[j];
					A[j] = tmp;
				} else {
					tmp = A[j];
					A[j] = tmp2;
					tmp2 = tmp;
				}
			}
		}
		
		return A;
	}

}
