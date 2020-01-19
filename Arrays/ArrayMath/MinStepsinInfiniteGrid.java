//  https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
package src.InterviewBit.Arrays.ArrayMath;

import java.util.ArrayList;
public class MinStepsinInfiniteGrid {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int first_len = A.size();
        int second_len = B.size();
        int i=1;
        int num_steps=0;
        int x = A.get(0);
        int y = B.get(0);
        while(i< first_len)
        {
            int x1 = A.get(i);
            int y1 = B.get(i);
            if(x1 == x)
            {
                num_steps += Math.abs(y-y1); // if x co ordinates are equal , num steps would be diff of y co ordinates
            }
            else if(y1 == y)
            {
                num_steps += Math.abs(x-x1);// if y co ordinates are equal , num steps would be diff of x co ordinates
            }
            else
            {
                // if both are not equal , diff would be max of diff of them as it can diagonally as well
                if(Math.abs(x-x1) > Math.abs(y-y1))
                {
                    num_steps += Math.abs(x-x1);
                }
                else
                {
                    num_steps += Math.abs(y-y1);
                }
            }

            x= x1; // initializing for next step
            y=y1;
            i++;
        }
        return num_steps;
    }
}
