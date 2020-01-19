package src.InterviewBit.Arrays.BucketingorSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

Input:


First list for arrival time of booking.
Second list for departure time of booking.
Third is K which denotes count of rooms.

Output:

A boolean which tells whether its possible to make a booking.
Return 0/1 for C programs.
O -> No there are not enough rooms for N booking.
1 -> Yes there are enough rooms for N booking.
Example :

Input :
        Arrivals :   [1 3 5]
        Departures : [2 6 8]
        K : 1

Return : False / 0

At day = 5, there are 2 guests in the hotel. But I have only one room.
 */
// https://www.interviewbit.com/problems/hotel-bookings-possible/
public class HotelBookings {
    //class myComparator implements Comparable
    static class Booking implements Comparable<Booking>
    {
        int start; // this is arrival or departure
        int end; // this is 0 for arrival , 1 for departure
        Booking(int x , int y)
        {
            start =x;
            end =y;
        }
        @Override
        public int compareTo(Booking newbooking) {
            if(this.start > newbooking.start)
                return 1;
            else if(this.start < newbooking.start)
                return -1;
            return 0;
        }
    }
    public static  boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int rooms_occupied =0;
        int total = arrive.size();
        ArrayList<Booking> total_bookings = new ArrayList<>();
        for(int i=0;i<total;++i)
        {
            total_bookings.add(new Booking(arrive.get(i),0)); // arrival is signified by 0
            total_bookings.add(new Booking(depart.get(i),1));// departure is signified by 1
        }
        Collections.sort(total_bookings);
        /*
        Collections.sort(arrive);
        System.out.println("arrive is "+Arrays.toString(arrive.toArray()));
        Collections.sort(depart);
        System.out.println("depart is "+Arrays.toString(depart.toArray()));
        */

        for(int i=0;i<total_bookings.size();++i)
        {
            System.out.println("current value  is "+total_bookings.get(i).start+"  "+total_bookings.get(i).end);
            if(total_bookings.get(i).end == 1)
            {
                rooms_occupied--;
            }
            else if(total_bookings.get(i).end == 0)
            {
                rooms_occupied++;
            }
            System.out.println("rooms occupied is "+rooms_occupied +"   for  "+total_bookings.get(i).start+"    "+total_bookings.get(i).end);
            if(rooms_occupied > K)
                return false;
        }


        /*
        for(int i=0;i<arrive.size() -1;++i)
        {
            if(depart.get(i) > arrive.get(i+1)) // overlapping
            {

                rooms_occupied++;
                System.out.println("rooms occupied for  "+depart.get(i)+"   is "+rooms_occupied);
            }
            if(K < rooms_occupied) {
                System.out.println("rooms occupied <k is "+depart.get(i)+"   is "+rooms_occupied);
                return false;
            }
        }

         */
        /*
        if(total == 1 && K >=1) {
            System.out.println("total booking is one "+K);
            return true;
        }
        for(int i=0;i<total_bookings.size();++i)
        {
            System.out.println(total_bookings.get(i).start+"  "+total_bookings.get(i).end);
        }
        System.out.println("availeble rroms are  "+ num_available_rooms);
        for(int i=1;i<total_bookings.size() && num_available_rooms >= 0;++i)
        {
            System.out.println("start and presvious end are "+total_bookings.get(i).start+"  "+total_bookings.get(i-1).end);
            if(total_bookings.get(i).start >=total_bookings.get(i-1).end) // if the next booking start date is > previous booking end , then room is possible , else room is not possible
            {

            }
            else
            {
                num_available_rooms--;
                if(num_available_rooms < 0)
                    System.out.println("room not available for "+total_bookings.get(i).start+"  "+total_bookings.get(i).end);
            }
        }


         */
        // this is the gfg solution but
        /*
        Collections.sort(arrive);
        Collections.sort(depart);
        int roomsRequired=0,i=0,j=0;
        while(i<arrive.size()  && j<arrive.size() && roomsRequired<=K){
            if(arrive.get(i)<depart.get(j) ){
                i++;
                roomsRequired++;
            }else{
                j++;
                roomsRequired--;
            }
        }
        if(roomsRequired<=K){
            return true;
        }else{
            return false;
        }

         */
        return true;
    }
    public static void main(String[] args)
    {
        //ArrayList<Integer> arrival = new ArrayList<>(Arrays.asList(13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8));
        //ArrayList<Integer> departure = new ArrayList<>(Arrays.asList(28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53));
        ArrayList<Integer> arrival = new ArrayList<>(Arrays.asList(40, 18));
        ArrayList<Integer> departure = new ArrayList<>(Arrays.asList(40,43 ));
        int num_room = 1;
        System.out.println("hotel booking possible is "+ hotel(arrival,departure,num_room));
    }
}
