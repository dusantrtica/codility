import unittest

# TOOD: if x and y are not of the same length, pad them with zeroes in front


def karatsuba_mul(x, y):
    n = len(str(x))
    if n == 1:
        return x * y

    m = int(n / 2)
    a = int(str(x)[0:m])
    b = int(str(x)[m:])
    c = int(str(y)[0:m])
    d = int(str(y)[m:])

    return 10**n * karatsuba_mul(a, c) + 10**m * (karatsuba_mul(a, d)+karatsuba_mul(b, c)) + karatsuba_mul(b, d)


class TestSum(unittest.TestCase):
    def test_case_0(self):
        self.assertEqual(karatsuba_mul(1, 2), 2)

    def test_case_1_(self):
        self.assertEqual(karatsuba_mul(4, 5), 20)

    def test_case_2(self):
        self.assertEqual(karatsuba_mul(1234, 5678), 7006652)

    def test_case_3(self):
        self.assertEqual(karatsuba_mul(20, 20), 400)

    def test_case_4(self):
        self.assertEqual(karatsuba_mul(12, 34), 408)


if __name__ == '__main__':

    unittest.main()
