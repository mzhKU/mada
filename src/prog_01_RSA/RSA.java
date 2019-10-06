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
        return BigInteger.valueOf(10);
    }

    public BigInteger findD(BigInteger e, BigInteger z) {
        // Extended Euklidian AlgorithM
        return BigInteger.valueOf(10);
    }

    public void savePrivateKey(BigInteger n, BigInteger d) {
        System.out.println("Saving private key.");
    }

    public void savePublicKey(BigInteger n, BigInteger e) {
        System.out.println("Saving public key.");
    }

}
