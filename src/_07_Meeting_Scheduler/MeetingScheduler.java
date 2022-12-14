package _07_Meeting_Scheduler;

import java.util.ArrayList;
import java.util.HashMap;

public class MeetingScheduler {
	/*
	 * Your task is to code a method to find a meeting time for two people given
	 * their schedules.
	 * 
	 * Code the method below so that it returns a Schedule object that contains all
	 * the times during the week that are in BOTH people's schedules. The Schedule
	 * class is included in this package.
	 * 
	 * Example: person1 availability - Monday at 9, Tuesday at 14, and Friday 10
	 * person2 availability - Tuesday at 14, Friday 8, and Monday at 9 The returned
	 * HashMap should contain: Tuesday 14 and Monday 9
	 * 
	 * The returned Schedule object represents the times both people are available
	 * for a meeting.
	 * 
	 * Time availability is always at the top of the hour, so 9:30 is not valid Time
	 * availability always represents 1 hour Assume both schedules are in the same
	 * time zones
	 */
	public static Schedule getMutualAvailability(Schedule person1, Schedule person2) {
		HashMap<String, ArrayList<Integer>> p1 = person1.getSchedule();
		HashMap<String, ArrayList<Integer>> p2 = person2.getSchedule();
		Schedule meetings = new Schedule();
		for (String key1 : p1.keySet()) {
			if (p2.containsKey(key1)) {
				ArrayList<Integer> ints = p1.get(key1);
				ArrayList<Integer> ints2 = p2.get(key1);
				for (Integer integer : ints2) {

					for (Integer value : ints) {
						if (value==integer) {
							meetings.addAvailability(key1, value);
							System.out.println(key1+" " + value);
						}
					}
				}
			}

		}
		/*
		 * for (int i = 0; i < 25; i++) { if(p1.containsValue(i) && p2.containsValue(i))
		 * { for (String day : p1.keySet()) { if(p2.containsKey(day)) {
		 * meetings.addAvailability(day, i); } } } }
		 */

		return meetings;

	}
}
