class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        dp = [0] * (len(nums) + 1)
        dp[1] = nums[0]
        length = 1
        for item in nums:
            if item > dp[length]:
                length += 1
                dp[length] = item
            else:
                i = length
                while i >= 0:
                    if dp[i - 1] < item < dp[i]:
                        break
                    i -= 1
                dp[i] = item
        return length


if __name__ == "__main__":
    solution = Solution()
    assert solution.lengthOfLIS([10,9,2,5,3,7,101,18]) == 4
    assert solution.lengthOfLIS([4,10,4,3,8,9]) == 3


