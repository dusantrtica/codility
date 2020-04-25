def canJump(nums):
    maxReachableIndex = 0
    n = len(nums)
    if n <= 1:
        return True
    for i, x in enumerate(nums):
        maxReachableIndex = max(x + i, maxReachableIndex)
        print(maxReachableIndex)
        if maxReachableIndex >= n-1:
            return True
        if x == 0 and maxReachableIndex <= i:
            return False
    return True


assert(canJump([3, 2, 1, 0, 4]) == False)
assert(canJump([2, 0, 0]) == True)
assert(canJump([2, 3, 1, 1, 4]) == True)
assert(canJump([3, 0, 8, 2, 0, 0, 1]) == True)

print('tests pass')
