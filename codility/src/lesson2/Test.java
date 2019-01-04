package lesson2;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		int[] testArr = new int[11];
		Random rand = new Random();
		
		for(int i = 0; i < testArr.length; i++) {
			if(i % 2 == 0) {
				// index가 짝수 일 때
				testArr[i] = rand.nextInt(10);
			} else {
				// index가 홀수 일 때
				if(i != 0) {
					testArr[i] = testArr[i-1];
				} 
			}
		}
		
		long start = System.nanoTime();
		
		System.out.println(solution(testArr));
		
		long end = System.nanoTime();
		
		System.out.println("실행시간 : " + (double)(end - start)/1000000000);
		
	}
	
	public static int solution(int[] A) {
		
		ArrayList<Integer> flag = new ArrayList<Integer>();
		int result = 0;
		int count = 0;
		boolean escape;;
		
		for(int i = 0; i < A.length; i++) {
			escape = false;
			
			// 리스트의 사이즈가 0이라면 아무값도 없으므로 확인한다.
			if(flag.size() > 0) {
				for(int j = 0; j < flag.size(); j++) {
					if(flag.get(j) == A[i]) {
						// 현재 arr[i] 값이 리스트에 포함되어 있다면 중복 확인을 할 필요가 없다.
						escape = true;
						break;
					}
				}
				
				// for 끝날 때 까지 리스트에 현재의 arr[i]값이 없다면 arr[i]값을 add
				if(!escape) {
					flag.add(A[i]);
				}
				
			} else {
				
				// 0이라면 처음시작되므로 무조건 add해야함
				flag.add(A[i]);
			}
			
			if(escape) {
				// true 라는 것은 앞에서 이미 체크했으므로 바로 다음 index로 넘어가면됨
				continue;
			} else {
				for(int j = 0; j < A.length; j++) {
					if(A[i] == A[j]) {
						count++;
					}
				}
			}
			if(count % 2 != 0) {
				result = A[i];
				break;
			}
			
			count = 0;
		}
		
		return result;
	}

}
