class Solution {
    public int minMeetingRooms(int[][] intervals){
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i = 0; i<intervals.length;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms=0;
        int endsItr=0;
        for(int i = 0; i<starts.length;i++){
            if(start[i]<end[endsItr]) {
                rooms++;
            }
            else {
                endsItr++;
            }
            return rooms;
        }
    }
}