package lesson03;

public class TapeEquilibrium {
	
	/**
	 * 
	 * @param A
	 * @return
	 * 
	 * 배열이 주어진다
	 * 배열의 첫번째 값과 두번째값 ~ 마지막 값의 합의 차의 절대값...
	 * 배열의 첫번째 + 두번째 값과 배열의 세번째 ~ 마지막 값의 합의 차의 절대값
	 * .
	 * .
	 * .
	 * 배열의 첫번째 값 ~ 배열의 길이 - 1 값의 합과 마지막 값 차의 절대값
	 * 중 절대값이 가장 작은 값을 구하는 것이다
	 * 효율적으로 함수를 작성하는 것이 중요
	 * 
	 * 해결방법1.
	 * 이중 반복문을 하면서
	 * sum1은 index 값을 계속 더하고
	 * sum2는 그 다음 index부터 마지막 인덱스까지 더하기
	 * 그리고 비교.
	 */
	public int solution(int[] A) {
		int min = 0;
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i = 0; i < A.length-1; i++) {
			
			sum1 += A[i];
			
			for(int j = i+1; j < A.length; j++) {
				sum2 += A[j];
			}
			
			// 확인
			int abs = Math.abs(sum1-sum2);
			sum1 = 0;
			sum2 = 0;
			
			if(i == 0) {
				min = abs;
			} else {
				if(min > abs)
					min = abs;
			}			
		}
		
		return min;
	}
	
	/**
	 * 해결방법2
	 * 먼저 합을 구해놓고
	 * first는 첫번째 index부터 값을 더해나가고
	 * second에는 sum에서 first를 빼면됨
	 * 그리고 비교.
	 * 이 방법이 이중 for문을 사용하지 않기 때문에 훨씬 빠름.
	 */
	public int solution2(int[] A) {
		int sum = 0;
		int first = 0;
		int second = 0;
		int min = 0;
		
		for(int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		
		for(int i = 1; i < A.length; i++) {
			first += A[i-1];
			second = sum - first;
			
			int abs = Math.abs(first-second);
			
			if(i == 1) {
				min = abs;
			}
			
			if(min > abs) {
				min = abs;
			}
			
		}
		return min;
	}
}
