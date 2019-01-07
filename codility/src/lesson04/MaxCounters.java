package lesson04;

public class MaxCounters {
	
	/**
	 * 
	 * @param N
	 * @param A
	 * @return
	 * 
	 * 정수 N과 배열 A가 주어진다.
	 * 배열 A는 1부터 N+1까지가 분포한다.
	 * A의 index값이 1~N까지라면 
	 * 0으로 초기화된 길이 N의 배열의 값을 + 1 시키고
	 * A의 index값이 N+1이라면 모든 배열의 값을 배열의 가장 큰 값으로 바꾼다.
	 * 
	 * A배열의 length만큼 반복하면
	 * N길이의 배열을 reteurn한다.
	 * 
	 * 해결방법 - 첫번째
	 * 만약 1과 N사이에 있다면 해당 값-1을 index로 하는 배열에 ++
	 * 그리고 N값과 같다면
	 * for문을 이용하여 max값으로 다 바꿈.
	 * 
	 * 가장 간단하게 생각할 수 있는 방법이나
	 * 이중 for문을 사용하여 timeOut...
	 * 77%나옴. 
	 */
	public int[] solution(int N, int[] A) {
			
		int[] arr = new int[N];
		int max = 0;
		
		for(int i = 0; i < A.length; i++) {
			if(A[i] >= 1 && A[i] <= N) {
				
				arr[A[i] - 1]++;
				if(arr[A[i] - 1] > max) {
					max = arr[A[i] - 1];
				}
				
				
			} else if(A[i] == N+1) {
				for(int j = 0; j < arr.length; j++) {
				    arr[j] = max;
				}
			}
		}
		
		return arr;
	}
	
	/**
	 * 두번째 방법
	 * for문을 한번쓰고 max값과 flagMax값을 두어 
	 * if문으로 처리.
	 * flag는 N+1값이 안나왔을 경우도 있을 때는 max값으로 바꾸면 안되므로 지정해줌.
	 * 100%
	 */
	public int[] solution2(int N, int[] A) {
		
		int[] arr = new int[N];
		boolean flag = false;
		int max = 0;
		int flagMax = 0;
		
		for(int i = 0; i < A.length; i++) {
			if(A[i] >= 1 && A[i] <= N) {
				if(flag && arr[A[i] -1] < max) {
					arr[A[i] - 1] = max;
				}
				
				arr[A[i] - 1]++;
				
				if(arr[A[i] - 1] > flagMax) {
					flagMax = arr[A[i] - 1];
				}
				
			} else if(A[i] == N+1) {
				flag = true;
				max = flagMax;
			}
		}
		
		if(flag) {
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] < max) {
					arr[i] = max;
				}
			}
		}
		
		
		return arr;
	}
}
