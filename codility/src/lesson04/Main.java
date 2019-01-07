package lesson04;

public class Main {

	public static void main(String[] args) {
		
		PermCheck pc = new PermCheck();
		MaxCounters test = new MaxCounters();
		
		
		int[] arr = {3, 4, 4, 6, 1, 4, 4};
		
		int[] result = test.solution2(5, arr);
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
