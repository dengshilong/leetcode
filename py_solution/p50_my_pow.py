class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        flag = False
        if n < 0:
            n = -n
            flag = True
        res = 1
        p = x
        while n > 0:
            if n % 2 == 1:
                res *= p
            p *= p
            n //= 2
        return res if not flag else 1 / res


if __name__ == "__main__":
    solution = Solution()
    assert solution.myPow(2.0, 10) == 1024.00000
    print(solution.myPow(2.10000, 3))
    print(solution.myPow(2.00000, -2))
