class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
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
                i = mid
                j = mid
                while i - 1 >= 0 and nums[i] == nums[i - 1]:
                    i -= 1
                while j + 1 < len(nums) and nums[j] == nums[j + 1]:
                    j += 1
                return [i, j]
        return [-1, -1]


if __name__ == "__main__":
    solution = Solution()
    assert solution.searchRange([5,7,7,8,8,10], 8) == [3, 4]
    assert solution.searchRange([5,7,7,8,8,10], 6) == [-1, -1]