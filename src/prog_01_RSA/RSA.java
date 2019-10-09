package prog_01_RSA;

import prog_01_RSA.algorithms.Alg;
import prog_01_RSA.algorithms.EEA;

import java.math.BigInteger;

public class RSA {

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;

    public BigInteger getProbablePrime(int lowerLimit) {
        return BigInteger.valueOf(lowerLimit).nextProbablePrime();
    }
    public BigInteger getProductOf(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }
    public BigInteger getPhi(BigInteger n) {
        BigInteger phi = this.getProductOf(this.getP().subtract(BigInteger.ONE), this.getQ().subtract(BigInteger.ONE));
        return phi;
    }

    public BigInteger ggT(BigInteger a, BigInteger b) {
        Alg eea = new EEA();
        BigInteger[] bezoutCoefficients = eea.bezout(a, b);
        BigInteger x0 = bezoutCoefficients[0];
        BigInteger y0 = bezoutCoefficients[1];
        return x0.multiply(a).add(y0.multiply(b));
    }

    public BigInteger findE(BigInteger n) {

        // m >= 2
        BigInteger e = BigInteger.ONE.add(BigInteger.ONE);

        // 'compareTo': returns 1 while e > zero.
        while (e.compareTo(BigInteger.ZERO) == 1) {
            if (this.ggT(e, this.getPhi(n)).equals(BigInteger.ONE)) {
                return e;
            }
            e = e.add(BigInteger.ONE);
        }
        return e;
    }


    /*
    public BigInteger findE(BigInteger z, BigInteger n) {

        // Approach: Start with the largest valid e.
        // e element of Z_phi(n) => e must be smaller than n.
        BigInteger e = n.subtract(BigInteger.ONE);
        BigInteger[] v;

        // Find the first e beginning from top that has ggT(e, z) = 1.
        // 'compareTo': returns 1 while e > zero.
        while (e.compareTo(BigInteger.ZERO) == 1) {
            v = eea(e, z);
            BigInteger x0 = v[2];
            BigInteger y0 = v[3];

            BigInteger ggT = bezout(x0, n, y0, e);

            if(ggT.equals(BigInteger.ONE)) {
                break;
            } else {
                e = e.subtract(BigInteger.ONE);
            }
        }
        return e;
    }
    */


    public BigInteger getP() {
        return p;
    }
    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return q;
    }
    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getN() {
        return n;
    }
    public void setN(BigInteger n) {
        this.n = n;
    }

    public void savePrivateKey(BigInteger n, BigInteger d) {
        System.out.println("Saving private key.");
    }
    public void savePublicKey(BigInteger n, BigInteger e) {
        System.out.println("Saving public key.");
    }
}
