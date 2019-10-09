package prog_01_RSA;

import prog_01_RSA.algorithms.Alg;
import prog_01_RSA.algorithms.EEA;

import java.math.BigInteger;

public class RSA {

    public BigInteger getProbablePrime(int lowerLimit) {
        return BigInteger.valueOf(lowerLimit).nextProbablePrime();
    }
    public BigInteger getProductOf(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }
    public BigInteger ggT(BigInteger a, BigInteger b) {

        Alg eea = new EEA();
        BigInteger[] bezoutCoefficients = eea.bezout(a, b);
        BigInteger x0 = bezoutCoefficients[0];
        BigInteger y0 = bezoutCoefficients[1];

        return x0.multiply(a).add(y0.multiply(b));
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





    public void savePrivateKey(BigInteger n, BigInteger d) {
        System.out.println("Saving private key.");
    }
    public void savePublicKey(BigInteger n, BigInteger e) {
        System.out.println("Saving public key.");
    }
}
