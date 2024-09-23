package binary_search;

import java.math.BigInteger;

public class NthRootOfNumber {
    int pow(long base, int exp, int m) {
//        long res = 1;
//        while (exp > 0) {
//            if ((exp & 1) != 0) {
//                res = res * base;
//                exp--;
//                if (res > m)
//                    return 2;
//            } else {
//                exp >>= 1;
//                base = base * base;
//                if (base > m)
//                    return 2;
//            }
//        }
//        if (res == m)
//            return 1;
//        return 0;

        return power(new BigInteger(String.valueOf(base)), exp, new BigInteger(String.valueOf(m)));
    }

    int power(BigInteger x, int y, BigInteger number) {
        BigInteger res = new BigInteger("1");
        while (y > 0) {
            if ((y & 1) != 0) {
                res = res.multiply(x);
                if (res.compareTo(number) > 0) {
                    return 2;
                }
            }
            y >>= 1;
            x = x.multiply(x);
        }
        if (res.compareTo(number) == 0)
            return 1;
        return 0;
    }

    public int NthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int flag = pow(mid, n, m);
            if (flag == 1) {
                return mid;
            } else if (flag == 2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 9, m = 1953125;
        NthRootOfNumber obj = new NthRootOfNumber();
        System.out.println(obj.NthRoot(n, m));
    }
}
