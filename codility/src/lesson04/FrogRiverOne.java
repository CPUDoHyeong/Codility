package lesson04;

import java.util.*;

public class FrogRiverOne {
	
	/**
	 * 
	 * @param X 
	 * @param A
	 * @return
	 * 
	 * 정수 X와 배열 A가 주어진다
	 * 개구리가 0의 위치에서 X+1 만큼의 위치로 이동하고 싶어한다.
	 * 개구리의 점프는 1만큼만 이동할 수 있으며
	 * 배열 A에는 강을 건너기 위해 나뭇잎의 위치들이 존재한다
	 * 예를들어 X가 3과 배열 [1, 2, 1, 3] 이 주어지면
	 * 개구리가 건널 수 있을 때는 A의 index가  3일 때이며
	 * return값은 3이 된다.
	 * 그리고 건널 수 없을 때는 return값이 -1이 된다.
	 * 이 때, 함수 solution을 효율적으로 작성하시오.
	 * 
	 * 해결방법
	 * 건널 수 없는 경우
	 *  1. 함수안에 연속된 값이 하나라도 없거나 X의 값이 없을 때
	 *  
	 * 우선 정렬을 한 다음에
	 * 같으면 continue 다르다면 이전인덱스와 +1했을 때 같은지 확인하고
	 * 같지 않으면 바로 return -1 
	 * 또한 X값까지 발견하면 break 한 다음에
	 * 정렬 전의 배열에서 index를 찾은 후 index를 return 한다.
	 */
	public int solution(int X, int[] A) {
		int[] sortA = A;
		Arrays.sort(sortA);
		boolean flag = false;
		
		for(int i = 0; i < sortA.length; i++) {
			if(i == 0) {
				if(sortA[i] != 1) {
					return -1;
				}
			} else {
				if(sortA[i-1] == sortA[i]) {
					continue;
				} else {
					if(sortA[i-1] + 1 != sortA[i]) {
						return -1;
					}
				}
				
			}
			
			if(sortA[i] == X) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			for(int i = 0; i < A.length; i++) {
				if(A[i] == X) {
					return i;
				}
			}
		}
		
		return -1;
	}
	
	/**
	 * 
	 * @param X
	 * @param A
	 * @return
	 * 
	 * 해결방법2
	 * 이중 for문은 시간복잡도가 높다.
	 * 따라서 for문을 한번 사용하여 하는 방법으로 함.
	 * 먼저 X+1을 길이로 하는 boolean 배열과
	 * 카운트 변수를 만든다.
	 * 
	 * 이 boolean 배열에는 A배열의 원소값들이
	 * index가 되어서 false값을 바꾸도록 했다.
	 * count는 바꿀 때 1씩 더해지도록 하여 X와 같아지면 그 때의
	 * i 즉 A배열의 index를 return 하게 하였음.
	 * 
	 * 예를 들어
	 * 5와 [1, 3, 2, 3, 5, 3, 4] 가 주어지면
	 * boolean 배열의 길이는 6이 되고 index는 5까지 주어짐(이 때의 return index는 6이 되야한다)
	 * 그리고 A의 길이 만큼 반복하면서
	 * 1일때는 test의 1의 index가 true로 바뀌면서 count++를
	 * 3일때는 test의 3의 index가 true로 바뀌면서 count++를
	 * .
	 * .
	 * 또한 중복되었다면 바로 continue를 통해 다음 index로 넘어가게함.
	 * 
	 * 이렇게 했을 때 count가 X값이 안되었다면 중간에 값이 없다는 것이고
	 * X값이 되었다는 것은 강을 건너가기위한 나뭇잎이 전부 연결되었다는 말이다.
	 * 그래서 그 때의 A배열의 index를 return해주면 되고 
	 * 그렇지 않는 경우는 -1을 return해 준다.
	 * 
	 * 조건에 배열의 값은 X이하기 때문에 가능하다.
	 * 그렇지 않을 경우는 배열접근에러가 test배열에서 뜰수있음.
	 */
	public int solution2(int X, int[] A) {
		boolean[] test = new boolean[X+1];
		int count = 0;
		
		for(int i = 0; i < A.length; i++) {
			if(test[A[i]] == false) {
				test[A[i]] = true;
				count++;
			} else {
				continue;
			}
			
			if(count == X) {
				return i;
			}
		}
		
		return -1;
	}
}
