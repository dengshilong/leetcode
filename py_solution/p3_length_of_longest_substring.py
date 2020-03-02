class Solution:
    def lengthOfLongestSubstring(self, s):
        if not s:
            return 0
        position = [-1] * 256
        result = 1
        length = 1
        start = 0
        position[ord(s[0])] = 0
        for i in range(1, len(s)):
            p = ord(s[i])
            if position[p] != -1:
                temp = position[p]
                position[p] = i
                if temp < start:
                    length += 1
                else:
                    result = max(result, length)
                    start = temp + 1
                    length = i - start + 1
            else:
                length += 1
                position[p] = i
        return max(result, length)


if __name__ == "__main__":
    solution = Solution()
    assert solution.lengthOfLongestSubstring('abcabcbb') == 3
    assert solution.lengthOfLongestSubstring('bbbbb') == 1
    assert solution.lengthOfLongestSubstring('pwwkew') == 3