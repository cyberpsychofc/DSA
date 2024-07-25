import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test {
    private int key;
    private int value;
    Test(int key, int value){
        this.key = key;
        this.value = value;
    }
    public static int getOldKey(int x, ArrayList<Test> objs){
        Iterator<Test> it = objs.iterator();
        while(it.hasNext()){
            Test current = it.next();
            if(current.key == x){
                objs.remove(current);
                return current.value;
            }
        }
        return -1;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        ArrayList<Test> pairs = new ArrayList<>();

        for(int x = 0; x < nums.length; x++){
            pairs.add(new Test(nums[x], x));
        }

        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);

        int i = 0;
        int j = nums.length - 1;

        while(i < j){
            int sum = temp[i] + temp[j];
            if(sum == target){
                res[0] = getOldKey(temp[i], pairs);
                res[1] = getOldKey(temp[j], pairs);
                return res;
            }
            if(sum < target)
                i++;
            else
                j--;
        }
        return res;
    }
    public static void main(String arg[]){
        int[] a = {3,3};
        int[] res = twoSum(a, 6);
        for(int c: res)
            System.out.print(c + " ");
    }
}
