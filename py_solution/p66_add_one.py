class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        res = []
        remain = 1
        for i in range(len(digits) - 1, -1, -1):
            t = digits[i] + remain
            res.append(t % 10)
            remain = int(t / 10)
        if remain:
            res.append(remain)
        res.reverse()
        return res


if __name__ == "__main__":
    solution = Solution()
    assert solution.plusOne([1,2,3]) == [1,2,4]
    assert solution.plusOne([4,3,2,1]) == [4,3,2,2]