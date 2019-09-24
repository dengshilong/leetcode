class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        res = '1'
        while n > 1:
            temp = []
            count = 1
            cur = res[0]
            for i in range(1, len(res)):
                if res[i] == cur:
                    count += 1
                else:
                    temp.append(str(count))
                    temp.append(cur)
                    cur = res[i]
                    count = 1
            if count:
                temp.append(str(count))
                temp.append(cur)
            res = ''.join(temp)
            n -= 1
        return res


if __name__ == "__main__":
    solution = Solution()
    # assert solution.countAndSay(1) == '1'
    assert solution.countAndSay(4) == '1211'