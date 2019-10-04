class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        while left <= right:
            while left + 1 <= right and nums[left + 1] == nums[left]:
                left += 1
            while left <= right - 1 and nums[right - 1] == nums[right]:
                right -= 1
            mid = int((right - left) / 2) + left
            if nums[mid] > nums[right]:
                left = mid + 1
            elif nums[mid] < nums[right]:
                right = mid
            else:
                return nums[mid]


if __name__ == "__main__":
    solution = Solution()
    assert solution.findMin([1,3,5]) == 1
    assert solution.findMin([2,2,2,0,1]) == 0