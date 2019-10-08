class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        res = []
        cur = [1]
        for i in range(1, numRows + 1):
            temp = []
            for j in range(i):
                if j == 0:
                    temp.append(1)
                elif j == i - 1:
                    temp.append(1)
                else:
                    temp.append(cur[j] + cur[j - 1])
            res.append(temp)
            cur = temp
        return res


if __name__ == "__main__":
    solution = Solution()
    assert solution.generate(3) == [[1], [1, 1], [1, 2, 1]]