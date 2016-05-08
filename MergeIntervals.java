import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                // TODO Auto-generated method stub
                if (a.start == b.start) {
                    if (a.end < b.end) {
                        return -1;
                    } else if (a.end > b.end){
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    if (a.start < b.start) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }    
        };
        Collections.sort(intervals, comp);
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0)
            return result;
        int i = 0;
        Interval cur = intervals.get(i);
        while (i < intervals.size()) {
            if (i + 1 < intervals.size()) {
                Interval next = intervals.get(i + 1);
                if (next.end <= cur.end) {
                    i++;
                    continue;
                }
                if (next.start <= cur.end) {
                    Interval temp = mergeInterval(cur, next);
                    cur = temp;
                    i += 1;
                } else {
                    result.add(cur);
                    i++;
                    cur = intervals.get(i);        
                }
            } else {
                break;
            }
        }
        result.add(cur);
        return result;
    }
    private static Interval mergeInterval(Interval a, Interval b) {
        Interval temp = new Interval();
        temp.start = a.start;
        temp.end = b.end;
        return temp;
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        int i = 0;
        return result;
    }
    public static void printIntervals(List<Interval> intervals) {
        for (Interval interval: intervals) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        int[][] values = {{1,3}, {1, 3}, {2,6}, {8, 10}, {15, 18}};
        for (int i = 0; i < values.length; i++) {
            Interval temp = new Interval(values[i][0], values[i][1]);
            intervals.add(temp);
        }
        List<Interval> result = merge(intervals);
        printIntervals(result);
    }    
}
