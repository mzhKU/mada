import prog_01_RSA.RSA;
import prog_01_RSA.Sieve;

import java.math.BigInteger;

import static java.lang.String.valueOf;

public class Main {

    private static RSA rsa;
    private static final int P_INIT = 1000000;
    private static final int Q_INIT = 2000000;

    private static BigInteger p;
    private static BigInteger q;
    private static BigInteger n;
    private static BigInteger z;
    private static BigInteger e;
    private static BigInteger d;

    public static void main(String[] args) {

        rsa = new RSA();

        p = rsa.getProbablePrime(P_INIT);
        q = rsa.getProbablePrime(Q_INIT);

        n = rsa.getProductOf(p, q);
        z = rsa.getProductOf(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE));

        e = rsa.findE(z);
        d = rsa.findD(e, z);


        rsa.savePrivateKey(n, d);
        rsa.savePublicKey(n, e);

        System.out.println(z);
    }
}
