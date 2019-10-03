class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        top = -1
        for i in range(len(nums)):
            if nums[i] != val:
                top += 1
                nums[top] = nums[i]
        return top + 1


if __name__ == "__main__":
    nums = [3, 2, 2, 3]
    solution = Solution()
    print(solution.removeElement(nums, 3), nums)