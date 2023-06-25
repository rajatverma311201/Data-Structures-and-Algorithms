package array;


/**
 *
 * MAJORITY ELEMENT
 * >n/2 times
 *
 */
public class MooresVotingAlogorithm {

    public int majorityElement(int[] nums)
    {

        int majNum= nums[0];

        int cnt = 0;

        for (int num :  nums)
        {
            if(cnt==0)
            {
                majNum = num;
                cnt=1;
            }
            else
            {
                if (majNum==num)
                {
                    cnt++;
                }
                else
                {
                    cnt--;
                }
            }
        }
        return majNum;
    }

}
