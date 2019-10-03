class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return len(nums)
        top = 0
        for i in range(1, len(nums)):
            if nums[top] != nums[i]:
                top += 1
                nums[top] = nums[i]
        return top + 1


if __name__ == "__main__":
    solution = Solution()
    nums = [1,1,2]
    print(solution.removeDuplicates(nums), nums)
