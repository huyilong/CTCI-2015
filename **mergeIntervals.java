/*
Sorting
sort the given intervals first by starting index and then by ending index


1. traverse the given interval and 
keep comparing current interval to the *last* interval in the result

2.1 if no intersection, just add current interval into result
2.2 otherwise, update the ending index of last interval 
in the result if necessary

*/
public class Interval{
	private int start;
	private int end;

	public Interval(){
		this.start = 0;
		this.end = 0;
	}

	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}


public class Solution{
	public List<Interval> merge(List<Interval> intervals){
		List<Interval> res = new ArrayList<>();
		if(intervals == null || intervals.size() ==0){
			return res;
		}

		Comparator<Interval> cmp = new Comparator<Interval>(){
			public int compare(Interval o1, Interval o2){
				if(o1.start != o2.start){
					return o1.start - o2.start;
				}else{
					return o1.end - o2.end;
				}
			}
		};

		Collections.sort(intervals, cmp);
		Interval ini = new Interval(intervals.get(0).start, intervals.get(0).end);
		res.add(ini);

		int i=1;//starting from the second interval in the sorted array
		//and always compare to the **last** interval in the res array
		while(i<intervals.size()){
			//loop until all the intervals are merged
			Interval cur = intervals.get(i);
			Interval prev = res.get(res.size()-1);////last interval in the result
			if(cur.start > prev.end){
				//no intersection between these two intervals
				//we just need to add it into the res without merging
				res.add(new Interval(cur.start, cur.end));
				//!!!!!
				//!!!!!
				//!!!!!
				//as long as we are adding result into the res
				//we need to each time new the sub!!!!! and then add
			}else{

				//there is a intersection between two intervals
				//we need to merge them together
				//and substitute the old one in the arraylist
				//////THIS IS WRONG!!!!!!
				//Interval merged = new Interval(prev.start, cur.end);
				Interval merged = new Interval(prev.start, prev.end > cur.end ? prev.end : cur.end);
				res.set(res.size()-1, merged);
			}

			i++;

		}

		return res;



	}
}