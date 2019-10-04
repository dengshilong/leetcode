class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        if not nums:
            return False
        left = 0
        right = len(nums) - 1
        while left <= right:
            while left + 1 <= right and nums[left + 1] == nums[left]:
                left += 1
            while left <= right - 1 and nums[right - 1] == nums[right]:
                right -= 1
            mid = int((right - left) / 2) + left
            if nums[mid] == target:
                return True
            elif nums[left] <= nums[mid]:
                if nums[left] <= target and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return False


if __name__ == "__main__":
    solution = Solution()
    assert solution.search([2,5,6,0,0,1,2], 0) == True
    assert solution.search([2,5,6,0,0,1,2], 3) == False