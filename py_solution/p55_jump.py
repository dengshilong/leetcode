class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums or len(nums) == 1:
            return True
        r = nums[0]
        for i in range(1, len(nums) - 1):
            if r == 0:
                return False
            r = max(nums[i], r - 1)
        return r >= 1


if __name__ == "__main__":
    solution = Solution()
    assert solution.canJump([2,3,1,1,4]) == True
    assert solution.canJump([3,2,1,0,4]) == False