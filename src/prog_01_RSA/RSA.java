package prog_01_RSA;

import java.math.BigInteger;

public class RSA {

    public BigInteger getProbablePrime(int lowerLimit) {
        return BigInteger.valueOf(lowerLimit).nextProbablePrime();
    }

    public BigInteger getProductOf(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    public BigInteger findE(BigInteger z) {
        // e = 1
        // if ggT(e, z) == 1:
        //    return e;
        return eea(BigInteger.valueOf(144), BigInteger.valueOf(84));
    }

    public BigInteger findD(BigInteger e, BigInteger z) {
        // Extended Euklidian Algorithm
        return BigInteger.valueOf(10);
    }

    public void savePrivateKey(BigInteger n, BigInteger d) {
        System.out.println("Saving private key.");
    }

    public void savePublicKey(BigInteger n, BigInteger e) {
        System.out.println("Saving public key.");
    }

    // Extended Euclidian Algorithm
    private BigInteger eea(BigInteger a, BigInteger b) {

        // Initialize
        BigInteger ap = a;
        BigInteger bp = b;
        BigInteger x0 = BigInteger.ONE;
        BigInteger y0 = BigInteger.ZERO;
        BigInteger x1 = BigInteger.ZERO;
        BigInteger y1 = BigInteger.ONE;
        BigInteger q = ap.divide(bp);
        BigInteger r = ap.mod(bp);

        String[] fields = {"ap", "bp", "x0", "y0", "x1", "y1", "q", "r"};
        BigInteger[] vInit  = {ap, bp, x0, y0, x1, y1, q, r};
        System.out.println(String.format("%4s %4s %4s %4s %4s %4s %4s %4s", fields));
        System.out.println(String.format("%4s %4s %4s %4s %4s %4s %4s %4s", vInit));

        while (bp != BigInteger.ZERO) {
            BigInteger x0tmp = x0;
            BigInteger y0tmp = y0;

            q = ap.divide(bp);
            r = ap.mod(bp);
            ap = bp;
            bp = r;
            x0 = x1;
            y0 = y1;
            x1 = x0tmp.subtract(q.multiply(x1));
            y1 = y0tmp.subtract(q.multiply(y1));

            BigInteger[] v = {ap, bp, x0, y0, x1, y1, q, r};
            System.out.println(String.format("%4s %4s %4s %4s %4s %4s %4s %4s", v));
        }
        System.out.println("EEA: " + x0.multiply(a).add(y0.multiply(b)));

        return x0.multiply(a).add(y0.multiply(b));
    }

}
