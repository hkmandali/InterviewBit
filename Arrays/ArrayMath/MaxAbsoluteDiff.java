package src.InterviewBit.Arrays.ArrayMath;
// https://www.interviewbit.com/problems/maximum-absolute-difference/
import java.util.ArrayList;
import java.util.Arrays;

public class MaxAbsoluteDiff {
    public static int maxArr(ArrayList<Integer> A) {
        int len = A.size();
        int max =0;
        int max1,max2;
        int min1,min2;
        max1 = min1 = A.get(0) + 1;
        max2 = min2 = A.get(0) - 1;
        int[] new_arr_plus = new int[len]; // we construct this new array from the existing array
        int[] new_arr_minus = new int[len]; // we construct this new array from the existing array
        for(int i=0;i<len;++i)
        {
            new_arr_plus[i] = A.get(i) + i+1;
            new_arr_minus[i] = A.get(i) - (i+1);
            max1= Math.max(max1,new_arr_plus[i]);
            max2= Math.max(max2,new_arr_minus[i]);
            min1= Math.min(min1,new_arr_plus[i]);
            min2= Math.min(min2,new_arr_minus[i]);
        }
        System.out.println("two arrays are "+ Arrays.toString(new_arr_plus)+"   "+Arrays.toString(new_arr_minus));
        System.out.println("max and min are "+max1+"  "+min1+"  "+ max2+"   "+min2);
        if(max1 - min1 > max2 - min2)
            max= max1 -  min1;
        else
            max = max2 - min2;

        return max;
    }
    public static void main(String[] args) {
        int[] test = {2, 2, 2 };
        ArrayList<Integer> obj = new ArrayList<>();
        for(int i:test)
            obj.add(i);
        System.out.println(" max is "+maxArr(obj));
    }
}
