package lesson01;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		System.out.println(solution(test));
		
	}
	
	public static int solution(int N) {
		
		int input = N;  
		int result = 0;     
		int zeroCount = 0;  
		
		String str = Integer.toBinaryString(input);
		int[] arr = new int[str.length()];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str.substring(i, i+1));
			System.out.print(arr[i] + " ");
			
			if(arr[i] == 1) {
				if(zeroCount > result) {
					result = zeroCount;
				}
				
				zeroCount = 0;
			} else if(arr[i] == 0) {
				zeroCount++;
			}
		}
		
		System.out.println();
		
		
		return result;
	}

}
