class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        self._recursion_permutation(nums, 0, result)
        return result

    def reverse(self, nums, begin, end):
        while begin < end:
            nums[begin], nums[end] = nums[end], nums[begin]
            begin += 1
            end -= 1


    def _recursion_permutation(self, nums, start, result):
        if start == len(nums) - 1:
            result.append([i for i in nums])
            return
        i = len(nums)
        while i > start:
            self._recursion_permutation(nums, start + 1, result)
            nums[start], nums[i - 1] = nums[i - 1], nums[start]
            i -= 1
            if i <= start:
                break
            self.reverse(nums, start + 1, len(nums) - 1)


if __name__ == "__main__":
    solution = Solution()
    print(solution.permute([1,2,3]))