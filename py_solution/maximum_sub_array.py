class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sum = 0
        res = nums[0]
        for n in nums:
            if sum < 0:
                sum = 0
            sum += n
            res = max(res, sum)
        return res



if __name__ == "__main__":
    solution = Solution()
    assert solution.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]) == 6