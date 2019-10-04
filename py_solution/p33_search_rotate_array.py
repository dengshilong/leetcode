class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums:
            return -1
        length = len(nums)
        left = 0
        right = length - 1
        while left <= right:
            mid = int((right - left) / 2) + left
            if nums[mid] == target:
                return mid
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
        return -1


if __name__ == "__main__":
    solution = Solution()
    # assert solution.search([4,5,6,7,0,1,2], 0) == 4
    # assert solution.search([4,5,6,7,0,1,2], 3) == -1
    assert solution.search([3, 1], 1) == 1
