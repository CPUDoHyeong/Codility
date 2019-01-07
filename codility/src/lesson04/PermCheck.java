package lesson04;

import java.util.*;

public class PermCheck {

	/**
	 * 
	 * @param A
	 * @return
	 * 
	 * 배열이 주어진다 배열이 순열인지 아닌지를 판단하여 
	 * A가 순열이면 1을 그렇지 않으면 0을 반환하는 함수를 작성해야 한다.
	 * 
	 * 여기서 순열이란 1부터 시작하여 중복되지 않도록 배열의 길이만큼
	 * 값이 분포해있어야 한다는 것이다. 정렬되어있을 필요는 없음.
	 * ex) [1, 3, 2, 4] 는 순열이다
	 * [1, 3, 4] 는 순열이 아니다.
	 * 
	 * 첫번째 풀이 방법
	 * 배열을 순서대로 오름차순으로 정렬하고
	 * 0번 인덱스부터 1씩 증가하고 있는지 확인했음.
	 * 문제는 [2, 3, 4] 일 때도 순열로 확인됨.
	 * 그래서 잘못된 접근 방법
	 */
	public int solution(int[] A) {

		Arrays.sort(A);

		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] != A[i + 1] - 1)
				return 0;
		}

		return 1;
	}
	
	/**
	 * 두번째 풀이 방법
	 * 배열의 길이 만큼 반복하면서
	 * 만약 해당 index값이 배열의 길이보다 크다면 바로 return;
	 * 이 방법이 간단하게 해결 할 수 있는 방법이라고 생각했지만
	 * 왜 100프로가 안나오는지 이해를 못하겠음.
	 * 아마 중복값이 있을때를 못 걸러준다는 것 같은데
	 * 문제 조건에 중복값은 없다는 것 같은데 ...
	 * 
	 */
	public int solution2(int[] A) {
		
		for(int i = 0; i < A.length; i++) {
			if(A[i] > A.length) return 0;
		}
		
		return 1;
		
	}
	
	/**
	 * 세번재 풀이 방법
	 * test라는 배열을 만들고
	 * 만약 A의 index값이 A의 length값보다 작거나 같으면
	 * 1을(true)를 집어넣는다
	 * 그리고 두번째 풀이 방법처럼
	 * length값보다 커버리면 바로 return 0을 한다.
	 * 
	 * 그리고 test배열을 반복하면서
	 * 0의 값이 있다면 return 0을 해주는 방법
	 * 이건 중복이 있는것까지 확인할 수 있음.
	 * 
	 */
	public int solution3(int[] A) {
		int[] test = new int[A.length + 1];

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= A.length) {
				test[A[i]] = 1;
			} else if(A[i] > A.length) {
				return 0;
			}
		}

		for (int i = 1; i < test.length; i++) {
			if (test[i] == 0)
				return 0;
		}

		return 1;
	}
}
