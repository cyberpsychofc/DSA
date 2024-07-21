import java.util.Arrays;
public class Test {
    public static void main(String arg[]){
        int a[] = {1,2,3,4,5,6};
        int b[] = Arrays.copyOfRange(a,3,5);
        for(int x:b)
            System.out.print(x + " ");
    }
}
