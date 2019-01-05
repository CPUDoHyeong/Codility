package lesson3;

import java.util.*;

public class PermMissingElem {
	
	/**
	 * 
	 * @param A -> 배열
	 * @return
	 * 
	 * 길이 N개의 서로 다른 정수로 구성된 배열 A를 입력받는다
	 * 배열에는 1부터시작하여 N+1까지의 범위가 포함되어 있는데
	 * 이 사이 숫자중 하나의 정수가 누락되어 있다.
	 * 이 누락된 숫자를 찾아 리턴해야 한다.
	 * 효율적인 알고리즘을 작성하는 것이 중요.
	 * 
	 * 해결방법
	 * 배열을 정렬하고
	 * 1부터 시작하므로 해당 index + 1의 값이 현재 배열의 i값과 같지 않다면 index+1을 return
	 * for문에서 return되지 않았다면
	 * 배열의 길이 + 1을 리턴한다.
	 * 
	 * 1부터 N+1까지인데
	 * 1부터 N까지 배열이 있고 N+1의 값이 누락될 수 있기 때문.
	 * 
	 */
	public int solution(int[] A) {
		Arrays.sort(A);
		
		for(int i = 0; i < A.length; i++) {
			if(i+1 != A[i]) return i+1;
		}
		return A.length + 1;
	}
}
