class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        nums = [i for i in range(1, n + 1)]
        return nth_permution(nums, k)


def nth_permution(nums, n):
    if n == 0:
        return ''.join(str(i) for i in nums)[::-1]
    s = [i for i in nums]
    p = 1
    for i in range(1, len(nums)):
        p *= i
    if n % p == 0:
        i = int(n / p)
        x = s[i - 1]
        s.remove(x)
        return str(x) + nth_permution(s, 0)
    elif n < p:
        x = s[0]
        s.remove(x)
        return str(x) + nth_permution(s, n)
    else:
        i = int(n / p)
        x = s[i]
        s.remove(x)
        return str(x) + nth_permution(s, n - i * p)


if __name__ == "__main__":
    solution = Solution()
    assert solution.getPermutation(3, 3) == "213"
    assert solution.getPermutation(4, 9) == "2314"



