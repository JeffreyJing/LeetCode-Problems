class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); //sort by start times
        //if the input is [0,30],[15,20],[5,10] --> after soring, it becomes [0,30],[5,10],[15,20]
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(); //create a priority queue
        //add end time of first sorted interval to the priority queue i.e [30] in this example
        queue.offer(intervals[0][1]); 
		
        for(int i=1; i< intervals.length; i++){ //start for loop from 1st index
		
		 //in each iteration, compare start time with peek of the priority queue. For example 5 >= 30? (in first interation)
            if(intervals[i][0] >= queue.peek()) {  
				queue.poll();  
			}
            queue.offer(intervals[i][1]); //add the current interval's end time to the queue [10] (in first iteration)
        }
        return queue.size(); //return the queue size
    }
}

/*
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> startingTimes = new PriorityQueue<Integer>();
        startingTimes.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > startingTimes.peek()) {
                startingTimes.poll();
            }
            
            startingTimes.add(intervals[i][1]);
            
        }
        
        return startingTimes.size();
    }
*/