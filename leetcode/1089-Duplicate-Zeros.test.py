import unittest


def duplicateZeroes(A):
    n = len(A)
    latestPushedIndex = n
    currentFromBehind = n
    i = 0

    while i < n:        
        originalValue = None
        if i >= latestPushedIndex:
            break

        originalValue = A[i]

        if currentFromBehind < n:
            originalValue = A[i]
            A[i], A[currentFromBehind] = A[currentFromBehind], A[i]            

        if originalValue == 0:
            latestPushedIndex -= 1
            A[latestPushedIndex] = 0
            if currentFromBehind == n:
                currentFromBehind -= 1

        i += 1


def duplicateZeroesWrapper(array):
    duplicateZeroes(array)
    return array


class TestSum(unittest.TestCase):
    def test_case_0(self):
        self.assertEqual(duplicateZeroesWrapper([0, 1, 0, 2, 3, 4, 5]), [0, 0, 1, 0, 0, 2, 3])
    def test_case_1(self):
        self.assertEqual(duplicateZeroesWrapper([1, 2, 3]), [1, 2, 3])

    def test_case_2(self):
        self.assertEqual(duplicateZeroesWrapper([1, 0, 1]), [1, 0, 0])

    def test_case_3(self):
        self.assertEqual(duplicateZeroesWrapper(
            [0, 0, 2, 3, 4]), [0, 0, 0, 0, 2])

    def test_case_4(self):
        self.assertEqual(duplicateZeroesWrapper(
            [1, 0, 2, 3, 0, 4, 5, 0]), [1, 0, 0, 2, 3, 0, 0, 4])

    def test_case_5(self):
        self.assertEqual(duplicateZeroesWrapper([1,3,0,2,3,3,4,4,0]), [1,3,0,0,2,3,3,4,4])

    def test_case_6(self):
        self.assertEqual(duplicateZeroesWrapper([9,0,9,0,6,0,0,0,1,1,6,5,4,4,8,3,0,0,0,1,5,3,0,0,7,2,1,0,2,0,9,1,0,2,0,0,0,0,0,0,0,6,0,0,7,9,0,8,7,0,9,7,1,0,2,0,0,0,0,9,0,0,0,0]), [9,0,0,9,0,0,6,0,0,0,0,0,0,1,1,6,5,4,4,8,3,0,0,0,0,0,0,1,5,3,0,0,0,0,7,2,1,0,0,2,0,0,9,1,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,0,0])


if __name__ == '__main__':
    unittest.main()
