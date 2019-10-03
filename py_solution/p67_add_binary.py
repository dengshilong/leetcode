class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        i = len(a) - 1
        j = len(b) - 1
        remain = 0
        s = 0
        res = []
        while i >= 0 and j >= 0:
            s = int(a[i]) + int(b[j]) + remain
            remain = int(s / 2)
            res.append(s % 2)
            i -= 1
            j -= 1
        while i >= 0:
            s = int(a[i]) + remain
            remain = int(s / 2)
            res.append(s % 2)
            i -= 1
        while j >= 0:
            s = int(b[j]) + remain
            remain = int(s / 2)
            res.append(s % 2)
            j -= 1
        if remain:
            res.append(remain)
        res.reverse()
        return ''.join([str(i) for i in res])


if __name__ == "__main__":
    solution = Solution()
    assert solution.addBinary('11', '1') == '100'
    assert solution.addBinary('1010', '1011') == '10101'
