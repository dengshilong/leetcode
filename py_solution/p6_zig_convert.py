class Solution:
    def convert(self, s, numRows):
        if numRows == 1:
            return s
        result = []
        step = numRows * 2 - 2
        for i in range(numRows):
            index = i
            add = i * 2
            while index < len(s):
                result.append(s[index])
                add = step - add
                index += step if i == 0 or i == numRows - 1 else add
        return ''.join(result)


if __name__ == "__main__":
    solution = Solution()
    assert solution.convert("LEETCODEISHIRING", 3) == 'LCIRETOESIIGEDHN'