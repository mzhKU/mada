import prog_01_RSA.RSA;

import java.math.BigInteger;

public class Main {

    private static final int P_INIT = 1000000;
    private static final int Q_INIT = 2000000;

    // Questions
    // - How to determine 'e'? Is it OK like this?
    // - How free is one in choosing e?
    // - Is 'd' unique for a given e?
    // - For a given n=p*q, are there multiple values for e, d?


    public static void main(String[] args) {

        RSA rsa = new RSA();

        // BigInteger p = rsa.getProbablePrime(P_INIT);
        // BigInteger q = rsa.getProbablePrime(Q_INIT);
        rsa.setP(BigInteger.valueOf(5));
        rsa.setQ(BigInteger.valueOf(7));
        rsa.setN(rsa.getProductOf(rsa.getP(), rsa.getQ()));

        BigInteger phi = rsa.getPhi(rsa.getN());

        BigInteger e = rsa.findE(rsa.getN());

        /*
        1: choose e
        2: choose d
         */

        BigInteger d = BigInteger.ONE;

        // BigInteger e = rsa.findE(z,n);

        // rsa.savePrivateKey(n, d);
        // rsa.savePublicKey(n, e);
    }
}
