class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = int((right - left) / 2) + left
            if nums[mid] > nums[right]:
                left = mid + 1
            elif nums[mid] < nums[right]:
                right = mid
            else:
                return nums[mid]


if __name__ == "__main__":
    solution = Solution()
    assert solution.findMin([3,4,5,1,2]) == 1
    assert solution.findMin([4,5,6,7,0,1,2]) == 0
