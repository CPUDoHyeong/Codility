package lesson03;

public class FlogJmp {
	
	/**
	 * 
	 * @param X -> 출발지점의 위치
	 * @param Y -> 도착지점의 위치
	 * @param D -> 점프 거리
	 * @return
	 * 
	 * 이 문제는 출발지점과 도착지점, 점프 거리를 받아서
	 * 출발지점에서 도착지점까지 최소의 점프 횟수는 몇번인지를 찾는 문제이다.
	 * 
	 * 해결방법
	 * 반복문을 사용하여 X에 D를 더하면서 Y가 될때까지 하는 방법도 있지만
	 * X와 Y의 차이가 크고 D가 작을 수록 많은 반복을 해야하는 단점이 있다.
	 * 하지만 도착지점에서 출발지점을 뺀 거리를 점프거리로 나눈다면 그 몫이 최소의 점프 횟수가 된다
	 * 단, 정확히 나누어 떨어질 때와 나머지가 있을 때를 구분해야 하므로 
	 * if else 문을 사용하여 처리한다.
	 * 
	 */
	public int solution(int X, int Y, int D) {
		int result = 0;
		
		if((Y - X) % D == 0) {
			result = (Y - X) / D;
		} else {
			result = (Y - X) / D + 1;
		}
		return result;
	}	
}
