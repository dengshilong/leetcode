class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        result = []
        if n == 0:
            result.append(0)
        else:
            temp = self.grayCode(n - 1)
            for item in temp:
                result.append(item)
            for i in range(len(temp)):
                result.append((1 << n - 1) + temp[len(temp) - i - 1])
        return result


if __name__ == "__main__":
    solution = Solution()
    print(solution.grayCode(0))
    print(solution.grayCode(3))