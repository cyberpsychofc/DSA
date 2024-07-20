package test;

public class CombinationBoardPath {
	public static void Boardpath(boolean arr[], int qpsf, int totq, String ans, int last) {
		if(qpsf == totq) {
			System.out.println(ans);
			return;
		}
		for(int i=last; i< arr.length; i++) {
			if(arr[i]==false) {
				arr[i] = true;
				Boardpath(arr,qpsf+1,totq, ans+ "q" + qpsf + "b"+i, i + 1);
				//undo the recursive action
				arr[i] = false;
			}
		}
	}
	public static void main(String arg[]) {
		boolean arr[] = new boolean[4];
		Boardpath(arr,0,2,"",0);
	}
}
