import prog_01_RSA.RSA;

import java.math.BigInteger;

public class Main {

    private static boolean fast = false;

    // Questions
    // - How to determine 'e'? Is it OK like this?
    // - How free is one in choosing e?
    // - Is EEA needed for finding e?
    // - Is 'd' unique for a given e?
    // - For a given n=p*q, are there multiple values for e, d?


    public static void main(String[] args) {
        int p_init;
        int q_init;

        if (fast) {
            p_init = 4;
            q_init = 6;
        } else {
            p_init = 1000000;
            q_init = 2000000;
        }

        RSA rsa = new RSA();

        BigInteger p = rsa.getProbablePrime(p_init);
        BigInteger q = rsa.getProbablePrime(q_init);
        rsa.setP(p);
        rsa.setQ(q);
        rsa.setN(rsa.getProductOf(rsa.getP(), rsa.getQ()));

        BigInteger phi = rsa.getPhi(rsa.getN());
        BigInteger e = rsa.findE(rsa.getN());
        BigInteger d = rsa.findD(e, phi);

        System.out.println("phi: " + phi);
        System.out.println("e: " + e);
        System.out.println("d: " + d);



        // rsa.savePrivateKey(n, d);
        // rsa.savePublicKey(n, e);
    }
}
