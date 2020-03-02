class Solution:
    def spiralOrder(self, matrix):
        res = []
        if not matrix:
            return res
        step = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        i = 0
        j = 0
        s = set()
        res.append(matrix[i][j])
        s.add(matrix[i][j])
        count = 1
        direction = 0
        m = len(matrix)
        n = len(matrix[0])
        while count < m * n:
            x = i + step[direction][0]
            y = j + step[direction][1]
            if x >= 0 and x < m and y >= 0 and y < n and matrix[x][y] not in s:
                res.append(matrix[x][y])
                s.add(matrix[x][y])
                i = x
                j = y
                count += 1
            else:
                direction = (direction + 1 + 4) % 4
        return res


if __name__ == "__main__":
    matrix = [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
    ]
    solution = Solution()
    assert solution.spiralOrder(matrix) == [1,2,3,6,9,8,7,4,5]
    matrix = [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9,10,11,12]
    ]
