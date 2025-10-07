package Day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ques1 {

    // Two Sum
    public int[] method1(int[] arr, int target){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public int[] method2(int[] arr, int target){
        int n = arr.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = arr[i];
            nums[i][1] = i;
        }

        Arrays.sort(nums, (a, b) -> a[0] - a[0]);
        int left = 0, right = arr.length-1;
        while (left < right){
            int sum = nums[left][0] + nums[right][0];
            if (sum == target){
                return new int[]{nums[left][1], nums[right][1]};
            }
            else if(sum > target){
                right--;
            }else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }


    public int[] method3(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int remain = target - arr[i];
            if (map.containsKey(remain))
                return new int[]{map.get(remain), i};
            return new int[]{arr[i], i};
        }
        return new int[]{-1, -1};
    }
}
