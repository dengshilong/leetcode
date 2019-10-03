class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        res = '1'
        while n > 1:
            temp = []
            i = 0
            while i < len(res):
                count = 1
                cur = res[i]
                while i + count < len(res) and res[i] == res[i + count]:
                    count += 1
                temp.append(str(count))
                temp.append(cur)
                i += count
            res = ''.join(temp)
            n -= 1
        return res


if __name__ == "__main__":
    solution = Solution()
    assert solution.countAndSay(1) == '1'
    assert solution.countAndSay(4) == '1211'