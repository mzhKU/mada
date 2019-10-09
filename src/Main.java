import prog_01_RSA.RSA;

import java.math.BigInteger;

public class Main {

    private static final int P_INIT = 1000000;
    private static final int Q_INIT = 2000000;

    // Questions
    // - How to determine 'e'? Is it OK like this?
    // - Is 'd' unique for a given e?
    // - For a given n=p*q, are there multiple values for e, d?


    public static void main(String[] args) {

        RSA rsa = new RSA();

        // BigInteger p = rsa.getProbablePrime(P_INIT);
        // BigInteger q = rsa.getProbablePrime(Q_INIT);
        BigInteger p = BigInteger.valueOf(5);
        BigInteger q = BigInteger.valueOf(7);

        BigInteger d = BigInteger.ONE;

        BigInteger n = rsa.getProductOf(p, q);
        BigInteger z = rsa.getProductOf(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE));
        System.out.println("n: " + n + ", z: " + z);

        // BigInteger e = rsa.findE(z,n);

        // System.out.println("ggT(e = " + String.format("%4s", e.toString()) + ", z = " + String.format("%4s", z.toString()) + ") = 1");

        // rsa.savePrivateKey(n, d);
        // rsa.savePublicKey(n, e);
    }
}
