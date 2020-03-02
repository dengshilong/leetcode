class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length <= 2:
            return length
        i = 0
        cur = nums[0]
        j = 1
        count = 1
        while j < length:
            if nums[j] == cur:
                count += 1
                if count > 2:
                    while j + 1 < length and nums[j + 1] == nums[j]:
                        j += 1
                else:
                    nums[i + 1] = cur
                    i += 1
            else:
                cur = nums[j]
                nums[i + 1] = nums[j]
                i += 1
                count = 1
            j += 1
        return i + 1


if __name__ == "__main__":
    solution = Solution()
    assert solution.removeDuplicates([1,1,1,2,2,3]) == 5
    assert solution.removeDuplicates([0,0,1,1,1,1,2,3,3]) == 7