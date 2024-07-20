public class InsertionSort {
    public static void insertionSort(int a[]){
        int n = a.length;
        for(int k = 1; k< n;k++){
            int cur = a[k];
            int j = k;
            while( j > 0 && a[j -1] > cur){
                System.out.println("k: "+ k + " cur: " + cur + " j: " + j);
                a[j] = a[j-1];
                j--;
            }
            a[j] = cur;
            System.out.println("data[j] = " + a[j]);
        }
    }
    public static void main(String arg[]){
        int arr[] = {5,4,8,3,6,2,1,7};
        insertionSort(arr);
        for(int i:arr)
            System.out.print(i + " ");
    }
}
