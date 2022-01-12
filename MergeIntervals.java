/* Ask whether the intervals will be in sorted or not
 sort the intervals and linear scan n merge O(NlogN) O(N^2)

 */

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals
{
    public int[][] merge(int[][] intervals)
    {
        // [[1,3],[2,6],[8,10],[15,18]]
        // [1,4], [2,3]
        // step-1: Sort Intervals based on Interval start
        // List<int[]>
        // Step-2: if(prevStart<=start) => mergeIntervals or just add current Interval

        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));

        List<int[]> result = new ArrayList<int[]>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++)
        {
            int[] currInterval = intervals[i];
            int[] prevInterval = result.get(result.size() - 1);
            if (prevInterval[1] >= currInterval[0])
            {
                prevInterval[1] = Math.max(currInterval[1], prevInterval[1]);
            }
            else
            {
                result.add(currInterval);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}