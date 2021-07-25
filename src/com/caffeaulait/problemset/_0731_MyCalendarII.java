package com.caffeaulait.problemset;

import java.util.Map;
import java.util.TreeMap;

public class _0731_MyCalendarII {
    /**
     * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.
     *
     * Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
     *
     * A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)
     *
     * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
     *
     * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
     * Example 1:
     *
     * MyCalendar();
     * MyCalendar.book(10, 20); // returns true
     * MyCalendar.book(50, 60); // returns true
     * MyCalendar.book(10, 40); // returns true
     * MyCalendar.book(5, 15); // returns false
     * MyCalendar.book(5, 10); // returns true
     * MyCalendar.book(25, 55); // returns true
     * Explanation:
     * The first two events can be booked.  The third event can be double booked.
     * The fourth event (5, 15) can't be booked, because it would result in a triple booking.
     * The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
     * The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
     * the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
     */
    private TreeMap<Integer, Integer> calendar;

    public _0731_MyCalendarII() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: calendar.entrySet()) {
            count += entry.getValue();
            if (count > 2) {
                calendar.put(start, calendar.get(start)-1);
                if (calendar.get(start) == 0) calendar.remove(start);
                calendar.put(end, calendar.get(end) + 1);
                if (calendar.get(end) == 0) calendar.remove(end);
                return false;
            }
        }
        return true;
    }
}
