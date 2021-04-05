package c1.week1;

public class KaratsubaMul {

  private int numberLength(long x) {
    int count = 0;
    while (x != 0) {
      x = x / 10;
      count++;
    }
    return count;
  }

  public long multiply(long x, long y) {
    int xLen = numberLength(x);
    int yLen = numberLength(y);

    if (xLen == 1 || yLen == 1) {
      return x * y;
    }

    int maxLen = Math.max(xLen, yLen);
    int maxLenOverTwo = (maxLen / 2) + (maxLen % 2);

    long tenToLengthOverTwo = (long) Math.pow(10, maxLenOverTwo);
    // Instead of % and / we should use bitwise operations here >> and <<
    // for shifting for some number of bits (n, where n is such: 2^n ~ tenToLength...)
    long b = x % tenToLengthOverTwo;
    long a = x / tenToLengthOverTwo;

    long d = y % tenToLengthOverTwo;
    long c = y / tenToLengthOverTwo;

    long z2 = multiply(a, c);
    long z1 = multiply(a + b, c + d);
    long z0 = multiply(b, d);

    return z0 + (z1 - z0 - z2) * tenToLengthOverTwo + (z2 * (long) (Math.pow(10, 2 * maxLenOverTwo)));
  }
}
