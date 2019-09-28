class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result = []
        self._generate_parenthesis(n, n, n, "", result)
        return result

    def _generate_parenthesis(self, left , right, n, s, result):
        if len(s) == n * 2:
            result.append(s)
        else:
            if left == right:
                self._generate_parenthesis(left - 1, right, n, s + '(', result)
            elif (left < right):
                if left > 0:
                    self._generate_parenthesis(left - 1, right, n, s + "(", result)
                self._generate_parenthesis(left, right - 1, n, s + ")", result)


if __name__ == "__main__":
    solution = Solution()
    assert solution.generateParenthesis(3) == [
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
    ]
