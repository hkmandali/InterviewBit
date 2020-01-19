package src.InterviewBit.Arrays.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverLapping {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    static class SortbyStart implements Comparator<Interval>
    {
        public int compare(Interval a, Interval b)
        {
            if( a.start > b.start)
                return 1;
            else if(a.start < b.start)
                return -1;
            else
                return 0;
        }
    }
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Stack<Interval> obj = new Stack<>();
        int size = intervals.size();
        Collections.sort(intervals, new SortbyStart());
        for(Interval i:intervals)
        {
            System.out.print(i.start+"  "+i.end+"  ");
        }
        obj.push(intervals.get(0));
        for(int i=1;i<size;++i)
        {
            Interval top = obj.peek();
            if(top.end < intervals.get(i).start)
                obj.push(intervals.get(i));
            else if(top.end < intervals.get(i).end)
            {
                top.end = intervals.get(i).end;
                obj.pop();
                obj.push(top);
            }
        }

        intervals.removeAll(intervals);
        while(!obj.isEmpty())
        {
            Interval top = obj.pop();
            intervals.add(top);
        }
        Collections.reverse(intervals);
        return intervals;
    }
    public static void main(String[] args)
    {
        ArrayList<Interval> obj = new ArrayList<>(10);
        obj.add(new Interval(1,3));
        obj.add(new Interval(2,6));
        obj.add(new Interval(8,10));
        obj.add(new Interval(15,18));
        merge(obj);
        for(Interval i:obj)
        {
            System.out.println(i.start+"  "+i.end+"  ");
        }


    }
}
