package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {



    public int[] isPresent(int[] nums, int target)
    {

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<nums.length; i++)
        {
            int remaining = target-nums[i];

            if(hm.containsKey(remaining))
            {
                return new int[]{hm.get(remaining), i};
            }
                hm.put(nums[i], i);
        }
        return new int[]{};
    }

}
