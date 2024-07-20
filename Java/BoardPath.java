
public class BoardPath {
	public static void Boardpath(boolean arr[], int qpsf, int totq, String ans) {
		if(qpsf == totq) {
			System.out.println(ans);
			return;
		}
		for(int i=0; i< arr.length; i++) {
			if(arr[i]==false) {
				arr[i] = true;
				Boardpath(arr,qpsf+1,totq, "q" + qpsf + "b" + i + ans);
				arr[i] = false;
			}
		}
	}
	public static void main(String arg[]) {
		boolean arr[] = new boolean[4];
		Boardpath(arr,0,2,"");
	}
}
