class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        res = 0
        cur = prices[0]
        for i in range(1, len(prices)):
            if prices[i] < cur:
                cur = prices[i]
            elif prices[i] > cur:
                res = max(res, prices[i] - cur)
        return res


if __name__ == "__main__":
    solution = Solution()
    a = [7,1,5,3,6,4]
    assert solution.maxProfit(a) == 5