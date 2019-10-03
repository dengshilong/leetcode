
class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        flag = False
        if x < 0:
            flag = True
            x = -x
        max = 2 ** 31 - 1
        result = 0
        while x > 0:
            result = result * 10 + x % 10
            x = int(x / 10)
            if result > max:
                return 0
        if flag:
            result = -result
        return result


if __name__ == "__main__":
    solution = Solution()
    print(solution.reverse(-1))
    print(solution.reverse(-24567))
    print(solution.reverse(1534236469))

