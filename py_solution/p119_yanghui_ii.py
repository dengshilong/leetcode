class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        res = [0] * (rowIndex + 1)
        res[0] = 1
        for i in range(1, rowIndex + 1):
            for j in range(i, 0, -1):
                if j == i:
                    res[j] = 1
                elif j == 0:
                    res[j] = 1
                else:
                    res[j] = res[j] + res[j - 1]
        return res


if __name__ == "__main__":
    solution = Solution()
    assert solution.getRow(3) == [1, 3, 3, 1]
