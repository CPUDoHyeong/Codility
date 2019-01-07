package lesson02;

import java.util.*;

public class Solution_2_2 {

	public static void main(String[] args) {
		// 효율적으로 짜기
		int[] arr = {3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 5};	
		
		
		ArrayList<Integer> flag = new ArrayList<Integer>();
		int result = 0;
		int count = 0;
		boolean escape;;
		
		for(int i = 0; i < arr.length; i++) {
			escape = false;
			
			// 리스트의 사이즈가 0이라면 아무값도 없으므로 확인한다.
			if(flag.size() > 0) {
				for(int j = 0; j < flag.size(); j++) {
					if(flag.get(j) == arr[i]) {
						// 현재 arr[i] 값이 리스트에 포함되어 있다면 중복 확인을 할 필요가 없다.
						escape = true;
						break;
					}
				}
				
				// for 끝날 때 까지 리스트에 현재의 arr[i]값이 없다면 arr[i]값을 add
				if(!escape) {
					flag.add(arr[i]);
				}
				
			} else {
				
				// 0이라면 처음시작되므로 무조건 add해야함
				flag.add(arr[i]);
			}
			
			if(escape) {
				// true 라는 것은 앞에서 이미 체크했으므로 바로 다음 index로 넘어가면됨
				continue;
			} else {
				for(int j = 0; j < arr.length; j++) {
					if(arr[i] == arr[j]) {
						count++;
					}
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
