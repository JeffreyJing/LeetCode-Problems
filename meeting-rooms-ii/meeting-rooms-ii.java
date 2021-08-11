class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> startingTimes = new PriorityQueue<Integer>();
        startingTimes.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= startingTimes.peek()) {
                startingTimes.poll();
            }
            
            startingTimes.offer(intervals[i][1]);
            
        }
        
        return startingTimes.size();
    }
}