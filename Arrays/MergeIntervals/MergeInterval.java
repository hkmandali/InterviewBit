package src.InterviewBit.Arrays.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/merge-intervals/
/*
Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
// not able to implement it , taken from interview bit
public class MergeInterval {
    public static class Interval {
      int start;
      int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
  }
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval current = newInterval; // we store this for the current one
        int size = intervals.size();
        System.out.println("size is "+size);
        int i=0;
        while(i<intervals.size())
        {
            System.out.println("current value is  "+intervals.get(i).start+" "+intervals.get(i).end);
            if(intervals.get(i).end < current.start)
            {
                // do nothing , just increment the counter
                i++;
            }
            else if(intervals.get(i).start > current.end)
            {
                intervals.add(i,current);
                break;
            }
            else
            {
                current.start = Math.min(intervals.get(i).start,current.start);
                current.end = Math.max(intervals.get(i).end,current.end);
                int j =i;
                intervals.remove(j);
            }
            System.out.println("removed , i value is "+i);
        }
        if(i == size)
        {
            if(intervals.size() == 0)
            {
                System.out.println("size is 0 , allocating one");
                intervals = new ArrayList<Interval>(1);
            }
            intervals.add(current);
            System.out.println("given one");
        }

        return intervals;
    }
    public static void main(String[] args)
    {
        ArrayList<Interval> obj = new ArrayList<>(10);/*
        obj.add(new Interval(1,2));
        obj.add(new Interval(3,5));
        obj.add(new Interval(6,7));
        obj.add(new Interval(8,10));
        obj.add(new Interval(12,16));

        */

        obj.add(new Interval(3,5));
        obj.add(new Interval(8,10));

        Interval newInterval = new Interval(1,12);
        ArrayList<Interval> res = insert(obj,newInterval);
        for(Interval i:res)
        {
            System.out.print(i.start+"  "+i.end+"  ");
        }

    }
}
