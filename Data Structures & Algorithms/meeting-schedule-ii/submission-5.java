/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] arr=new int[1000001];
        for(int i=0;i<intervals.size();i++){
            int st=intervals.get(i).start;
            int en=intervals.get(i).end;
            arr[st]+=1;
            if(en<arr.length)arr[en]-=1;
        }

        int max=0;
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
            max=Math.max(max, arr[i]);
        }
        return max;
    }
}
