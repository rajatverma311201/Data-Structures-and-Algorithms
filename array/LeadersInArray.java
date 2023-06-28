package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * Everything on the right of a leader should be smaller
 * 
 * nums[] = {10, 22, 12, 3, 0, 6}
 * 
 * Answer
 * leaders[] = {6, 12, 22}
 * 
 * 
 * 
 * https://takeuforward.org/data-structure/leaders-in-an-array/
 * 
 * https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=leaders-in-an-array
 * 
 */

public class LeadersInArray {

    public List<Integer> getLeaders(int[] nums) {
        List<Integer> li = new ArrayList<>();

        int currMax = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] > currMax) {
                li.add(nums[i]);
                currMax = nums[i];
            }

        }
        return li;
    }
}
