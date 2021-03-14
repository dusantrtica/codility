import unittest


def mergesortedarrays(A, B):
    n = len(A)
    m = len(B)

    C = []

    i, j = 0, 0

    while i < n and j < m:
        if(A[i] < B[j]):
            C.append(A[i])
            i += 1
        else:
            C.append(B[j])
            j += 1

    if i == n:
        C.extend(B[j:])
    if j == m:
        C.extend(A[i:])

    return C


def mergesort(A):
    n = len(A)
    if n <= 1:
        return A
    elif n == 2:
        [x, y] = A
        if x > y:
            return [y, x]
        return A
    else:
        m = int(n / 2)
        x = mergesort(A[0:m])
        y = mergesort(A[m:])
        return mergesortedarrays(x, y)


class TestSum(unittest.TestCase):
    def test_case_0(self):
        self.assertEqual(mergesort([2, 1]), [1, 2])

    def test_case_1(self):
        self.assertEqual(mergesort([4, 2, 1, 6, 2]), [1, 2, 2, 4, 6])

    def test_case_2(self):
        self.assertEqual(mergesort([]), [])


if __name__ == '__main__':
    unittest.main()
