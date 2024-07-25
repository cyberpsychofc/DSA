public class Matrix {
    public static void spiral(int [][] a){
        int top = 0;
        int bottom = a.length - 1;
        int left = 0;
        int right = a[0].length - 1;

        while(top <= bottom && left <= right){

            for(int i=left; i <= right; i++)
                System.out.print(a[top][i]+" ");
            top++;

            for(int i=top; i <=bottom; i++)
                System.out.print(a[i][right]+" ");
            right--;

            if(top <= bottom){
                for(int j=right; j>=left; j--){
                    System.out.print(a[bottom][j] + " ");
                }
                bottom--;
            }
            if(left <= right){
                for(int j=bottom; j>= top; j--){
                    System.out.print(a[j][left]+" ");
                }
                left++;
            }
        }
    }
    public static void main(String arg[]){
        int arr[][] = { {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
        spiral(arr);
    }
}
