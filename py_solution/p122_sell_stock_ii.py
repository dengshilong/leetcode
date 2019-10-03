class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        res = 0
        i = 0
        length = len(prices)
        cur = None
        while i < length:
            if cur is None:
                cur = prices[i]
                i += 1
                continue
            if prices[i] < cur:
                cur = prices[i]
            elif prices[i] > cur:
               if i + 1 == length or prices[i + 1] < prices[i]:
                    res += prices[i] - cur
                    cur = None
            i += 1
        return res


if __name__ == "__main__":
    solution = Solution()
    assert solution.maxProfit([7,1,5,3,6,4]) == 7
    assert solution.maxProfit([1,2,3,4,5]) == 4
    assert solution.maxProfit([7,6,4,3,1]) == 0
    assert solution.maxProfit([2,1,2,0,1]) == 2
