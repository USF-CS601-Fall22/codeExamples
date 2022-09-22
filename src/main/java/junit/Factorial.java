package junit;

public class Factorial {
    public static int compute(int n) {
        int res = 1;
        for (int i  = 1; i <= n; i++)
            res = res * i;
        return res;
    }
}
