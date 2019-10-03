

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = {}
        default_result = [0, 0]
        for i in range(len(nums)):
            temp = target - nums[i]
            if temp in map:
                result = [map[temp], i]
                return result
            map[nums[i]] = i
        return default_result


if __name__ == "__main__":
    solution = Solution()
    print(solution.twoSum([2, 7, 11, 15], 9))

