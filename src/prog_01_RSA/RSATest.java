package prog_01_RSA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class RSATest {

    RSA rsa;
    BigInteger five;
    BigInteger seven;

    @BeforeEach
    void setup() {
        rsa = new RSA();
        five = BigInteger.valueOf(5);
        seven = BigInteger.valueOf(7);
    }

    @Test
    void testggT() {
        BigInteger a = BigInteger.valueOf(100);
        BigInteger b = BigInteger.valueOf(75);
        BigInteger c = BigInteger.valueOf(18);
        BigInteger d = BigInteger.valueOf(7);

        assertEquals(BigInteger.valueOf(25), rsa.ggT(a, b));
        assertEquals(BigInteger.valueOf(1),  rsa.ggT(c, d));
    }

    @Test
    void getProbablePrime() {
        assertEquals(BigInteger.valueOf(101), rsa.getProbablePrime(100));
    }

    @Test
    void getProductOf() {
        assertEquals(rsa.getProductOf(five, seven), BigInteger.valueOf(35));
    }

    @Test
    void testFindE() {
        rsa.setP(five);
        rsa.setQ(seven);
        rsa.setN(rsa.getProductOf(rsa.getP(), rsa.getQ()));
        assertEquals(five, rsa.findE(rsa.getN()));
    }

    @Test
    void testFindD() {
        rsa.setP(five);
        rsa.setQ(seven);
        rsa.setN(rsa.getProductOf(rsa.getP(), rsa.getQ()));
        BigInteger d = rsa.findD(rsa.getN());
        BigInteger e = rsa.findE(rsa.getN());
        assertEquals(e.multiply(d).mod(BigInteger.valueOf(31)), BigInteger.valueOf(9).multiply(BigInteger.valueOf(9)).mod(BigInteger.valueOf(31)));
    }
}