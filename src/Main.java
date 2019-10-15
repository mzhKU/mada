import prog_01_RSA.RSA;
import prog_01_RSA.Writer;

import java.io.IOException;
import java.math.BigInteger;

public class Main {

    private static boolean fast = false;
    private static boolean log = true;
    private static final String SECRET_KEY = "my-sk.txt";
    private static final String PUBLIC_KEY = "my-pk.txt";

    // Questions
    // - How to determine 'e'? Is it OK like this?
    // - How free is one in choosing e?
    // - Is EEA needed for finding e?
    // - Is 'd' unique for a given e?
    // - For a given n=p*q, are there multiple values for e, d?


    public static void main(String[] args) {
        int p_init;
        int q_init;

        String fn = "text.txt";

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

        if (log) {
            System.out.println("phi: " + phi);
            System.out.println("n: " + rsa.getN());
            System.out.println("e: " + e);
            System.out.println("d: " + d);
        }

        // Write secret key.
        try {
            Writer.writeKey(SECRET_KEY, rsa.getN(), d);
        }  catch (IOException ex){
            System.out.println("Key not written.");
        }

        // Write private key.
        try {
            Writer.writeKey(PUBLIC_KEY, rsa.getN(), e);
        } catch (IOException ex){
            System.out.println("Key not written.");
        }

        rsa.encode(fn);

        // Tasks 3 & 4
        rsa.decode();

        // rsa.savePrivateKey(n, d);
        // rsa.savePublicKey(n, e);
    }
}
