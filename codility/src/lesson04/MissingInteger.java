package lesson04;

import java.util.*;

public class MissingInteger {
	
	/**
	 * 
	 * @param A
	 * @return
	 * 
	 * 배열 A가 주어진다.
	 * 이 배열에서 빠져있는 정수 중 가장 작은 정수를 반환해야 한다.
	 * 배열이 [1, 3, 2, 5, 2] 일 때
	 * 4가 빠져있으므로 4를 반환해야 한다.
	 * 
	 * 해결방법
	 * 음수만 넣었을 경우와 1이 비어있을 경우는
	 * 무조건 1이 반환해야 하므로
	 * 먼저 result를 1로 지정한다.
	 * 그리고 배열을 오름차순 정렬하고
	 * 배열의 값들이 0보다 크고 result와 같다면
	 * result를 ++ 해주는 식
	 * 
	 * 예를들어 [1, 4, 5, 3, -5]가 주어졌을 때
	 * 정렬하면 -5, 1, 3, 4, 5 가 되고
	 * -5는 무시
	 * 1은 result와 같기때문에 result는 2
	 * 3부터는 result와 같지 않기때문에 if를 거치지 않음
	 * 그래서 2가 return 됨.
	 * 
	 * [-1, 2] 가 주어지면
	 * -1은 무시
	 * 2는 if를 거치지 않으므로 원래의 result은 1이 return됨.
	 * 
	 * [1, 2] 가 주어지면
	 * 1은 if를 거쳐 result가 2.
	 * 2는 if를 거쳐 result가 3.
	 * return 은 3.
	 * 
	 */
	public int solution2(int[] A) {
		int result = 1;
		
		Arrays.sort(A);
		
		for(int i = 0; i < A.length; i++) {
			if(A[i] > 0 && A[i] == result) {
				result++;
			}
		}
		
		return result;
	}
}
