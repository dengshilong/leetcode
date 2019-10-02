class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        i = 0
        j = 0
        k = len(nums) - 1
        while j <= k:
            if nums[j] == 0:
                if i != j:
                    nums[i], nums[j] = nums[j], nums[i]
                i += 1
                j += 1
            elif nums[j] == 2:
                nums[k], nums[j] = nums[j], nums[k]
                k -= 1
            else:
                j += 1


if __name__ == "__main__":
    solution = Solution()
    nums = [2,0,2,1,1,0]
    solution.sortColors(nums)
    assert nums == [0,0,1,1,2,2]