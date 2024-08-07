import java.util.Arrays;
import java.util.Random;
public class ArrayTest {
    public static void main(String arg[]){
        int data[] = new int[10];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        for(int i=0; i<data.length; i++)
            data[i] = rand.nextInt(100);
        int org[] = Arrays.copyOf(data,data.length);
        System.out.println("arrays equal before sort : " + Arrays.equals(data, org));
        Arrays.sort(data);
        System.out.println("arrays equal after sort : " + Arrays.equals(data,org));
        System.out.println("orig = " + Arrays.toString(org));
        System.out.println("data = " + Arrays.toString(data));
    }
}
