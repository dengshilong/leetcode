class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = int((right - left) / 2) + left
            if nums[mid] < target:
                left += 1
            elif nums[mid] > target:
                right -= 1
            else:
                return mid
        return left


if __name__ == "__main__":
    solution = Solution()
    assert solution.searchInsert([1,3,5,6], 5) == 2
    assert solution.searchInsert([1,3,5,6], 2) == 1
    assert solution.searchInsert([1,3,5,6], 7) == 4
    assert solution.searchInsert([1,3,5,6], 0) == 0