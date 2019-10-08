import prog_01_RSA.RSA;

import java.math.BigInteger;

public class Main {

    private static final int P_INIT = 1000000;
    private static final int Q_INIT = 2000000;

    public static void main(String[] args) {

        RSA rsa = new RSA();

        // BigInteger p = rsa.getProbablePrime(P_INIT);
        // BigInteger q = rsa.getProbablePrime(Q_INIT);
        BigInteger p = BigInteger.valueOf(5);
        BigInteger q = BigInteger.valueOf(7);

        BigInteger n = rsa.getProductOf(p, q);
        BigInteger z = rsa.getProductOf(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE));
        System.out.println("n: " + n + ", z: " + z);


        BigInteger e = rsa.findE(z,n);





        System.out.println("ggT(%4s, " + e + " %4s): " + z);
        BigInteger d = rsa.findD(e, z);

        rsa.savePrivateKey(n, d);
        rsa.savePublicKey(n, e);

        System.out.println(z);


    }
}
