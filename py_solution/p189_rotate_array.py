def reverse(nums, start, end):
    while start < end:
        nums[start], nums[end] = nums[end], nums[start]
        start += 1
        end -= 1

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        k = k % length
        reverse(nums, 0, length - k - 1)
        reverse(nums, length - k, length - 1)
        reverse(nums, 0, length - 1)


if __name__ == "__main__":
    solution = Solution()
    nums = [1,2,3,4,5,6,7]
    solution.rotate(nums, 3)
    assert nums == [5,6,7,1,2,3,4]
    nums = [-1,-100,3,99]
    solution.rotate(nums, 2)
    assert nums == [3,99,-1,-100]