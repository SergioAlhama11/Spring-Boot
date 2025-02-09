package com.sergio.springboot.first_rest_api.example;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public int findMaxLength(int[] nums) {
		
		if (null == nums || nums.length == 0) {
			return 0;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				nums[i] = -1;
			}
		}
		
		int sum = 0;
		int max = 0;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		map.put(0, -1);
		
		for(int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			
			if (map.containsKey(sum)) {
				max = Math.max(max, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		
		return max;
        
	}
	
public class NumArray {
	
	public int[] prefixSum;

	public NumArray(int[] nums) {
		
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i];
		}
		
		prefixSum = nums;
	        
	}
	    
	public int sumRange(int left, int right) {
		
		if (left == 0) {
			return prefixSum[right];
		}
		
		return prefixSum[right] - prefixSum[left-1];
	        
	}
}
	
}
