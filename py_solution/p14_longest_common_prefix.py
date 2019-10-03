class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs or len(strs) == 0:
            return ''
        pre = strs[0]
        i = 1
        while i < len(strs):
            while strs[i].find(pre) != 0:
                pre = pre[0:len(pre) - 1]
            i += 1
        return pre


if __name__ == "__main__":
    solution = Solution()
    assert solution.longestCommonPrefix(["flower","flow","flight"]) == 'fl'
    assert solution.longestCommonPrefix(["dog","racecar","car"]) == ''