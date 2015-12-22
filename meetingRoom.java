/*
Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],…] (si < ei), determine if a person could attend all meetings.

For example, Given [[0, 30],[5, 10],[15, 20]], return false.

Solution

Sorting
1. sorting by start time
2. sorting by end time

sort interval first by start time and then by end time

traverse the sorted intervals and check if two intervals have intersection 
with each other
*/

public class Interval{
	//default as private members
	int start;
	int end;
	Interval(){
		start = 0;
		end=0;
	}
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}

public class Solution{
	public boolean canAttendMeetings(Interval[] schedules){
		if(schedules == null || shcedules.length == 0){
			return false;
		}

		//using self-defined comparator
		//Arrays.sor(arr, cmp)
		Comparator<Interval> cmp = new Comparator<Interval>(){
			@override
			//here we 
			public int compare(Interval o1, Interval o2){
				if(o1.start != o2.start){
					//we firstly compare the starting time
					return o1.start - o2.start;
				}else{
					//then compare the end time
					return o1.end - o2.end;
				}
			}
		};

		Arrays.sort(schedules, cmp);

		//we are stating from 1 
		for(int i=1;i<schedules.length; i++){
			if(schedules[i].start < schedules[i-1].end){
				return false;
			}
		}

		//after checking all these intervals 
		//we sort each interval by starting time and then end time
		return true;
	}
}