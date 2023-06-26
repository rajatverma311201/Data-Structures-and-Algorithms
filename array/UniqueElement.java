package array;


/**
 * All Elements occur twice except one element
 * Find that unique element
 *
 * use XOR property
 *
 * ^ denotes XOR
 *
 * A^A = 0
 *
 * 0^B = B
 */
public class UniqueElement {

    public  int findUnique(int[] nums)
    {
        int xor = 0;
        for(int num : nums)
        {
            xor = xor ^ num;
        }

        return xor;
    }


}
