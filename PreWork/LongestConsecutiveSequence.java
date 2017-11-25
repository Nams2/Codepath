package com.namrata;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *
Longest Consecutive Sequence
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 Example:
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.

 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(final List<Integer> a) {
        if (a.size() == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int e : a)
            set.add(e);

        for (int e : a) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}
