class Solution:
    def sortedSquares(self, A):
        B = []
        if A[-1] <= 0:
            return [e*e for e in A[::-1]]
        if A[0] >= 0:
            return [e*e for e in A]

        j = 0
        while A[j] < 0:
            j += 1
        i = j-1
        while i >= 0 and j < len(A):
            sqrI = A[i]*A[i]
            sqrJ = A[j]*A[j]
            if sqrI < sqrJ:
                B.append(sqrI)
                i -= 1
            else:
                B.append(sqrJ)
                j += 1

        if j < len(A):
            return [*B, *[x*x for x in A[j:]]]
        if i >= 0:
            return [*B, *[x*x for x in A[i::-1]]]


s = Solution()
assert(s.sortedSquares([-3, 0, 2]) == [0, 4, 9])
assert(s.sortedSquares([-7, -3, 2, 3, 11]) == [4, 9, 9, 49, 121])
assert(s.sortedSquares([-4, -1, 0, 3, 10]) == [0, 1, 9, 16, 100])
assert(s.sortedSquares([-1, 1]) == [1, 1])

print('test pass')
