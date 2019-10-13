package prog_01_RSA.algorithms;

import java.math.BigInteger;

public class EEA implements Alg {

    private final BigInteger[] bezoutCoefficients = {BigInteger.ONE, BigInteger.ZERO};

    private Boolean log = false;

    @Override
    public BigInteger[] bezout(BigInteger a, BigInteger b) {

        // Initialize
        BigInteger ap = a,               bp = b;
        BigInteger x0 = BigInteger.ONE,  y0 = BigInteger.ZERO;
        BigInteger x1 = BigInteger.ZERO, y1 = BigInteger.ONE;
        BigInteger  q = ap.divide(bp),    r = ap.mod(bp);

        BigInteger[] v = {ap, bp, x0, y0, x1, y1, q, r};

        if (log) {
            String[] fields = {"ap", "bp", "x0", "y0", "x1", "y1", "q", "r"};
            System.out.println(String.format("%4s %4s %4s %4s %4s %4s %4s %4s", fields));
            System.out.println(String.format("%4s %4s %4s %4s %4s %4s %4s %4s", v));
        }

        while (bp != BigInteger.ZERO) {
            BigInteger x0tmp = x0;
            BigInteger y0tmp = y0;

            q = ap.divide(bp);  r = ap.mod(bp);
            ap = bp;            bp = r;
            x0 = x1;            y0 = y1;
            x1 = x0tmp.subtract(q.multiply(x1));
            y1 = y0tmp.subtract(q.multiply(y1));

            v[0] = ap; v[1] = bp;
            v[2] = x0; v[3] = y0;
            v[4] = x1; v[5] = y1;
            v[6] = q;  v[7] = r;

            if (log) {
                System.out.println(String.format("%4s %4s %4s %4s %4s %4s %4s %4s", v));
            }
        }

        if (log) {
            System.out.println("\n");
        }

        bezoutCoefficients[0] = x0;
        bezoutCoefficients[1] = y0;

        return bezoutCoefficients;
    }
}
