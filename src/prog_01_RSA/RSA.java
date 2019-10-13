package prog_01_RSA;

import prog_01_RSA.algorithms.Alg;
import prog_01_RSA.algorithms.EEA;
import prog_01_RSA.algorithms.Multiplier;

import java.io.IOException;
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

    public BigInteger findD(BigInteger e, BigInteger phi) {
        Alg eea = new EEA();

        // [0] is the y0 Bezout coefficient
        BigInteger d = eea.bezout(e, phi)[0];

        // If the coefficient is < 0, 'compareTo' returns -1.
        if (d.compareTo(BigInteger.ZERO) == -1) {
            d = d.add(phi);
        }
        // Kontrolle s. Skript s. 28
        // System.out.println("Kontrolle d:" + eea.bezout(BigInteger.valueOf(31), BigInteger.valueOf(9))[1]);
        return d;

    }


    public void encode(String fn) {
        Multiplier multiplier = new Multiplier();
        int asciiOfChar;
        BigInteger encodedSymbol;
        try {
            String pk = Reader.readFile("pk.txt");
            BigInteger n = BigInteger.valueOf(Long.parseLong(pk.split(" ")[0]));
            BigInteger e = BigInteger.valueOf(Long.parseLong(pk.split(" ")[1]));
            String msg = Reader.readFile(fn);

            for(int i = 0; i < msg.length(); i++) {
                asciiOfChar = (int) msg.charAt(i);
                encodedSymbol = multiplier.fastExp(asciiOfChar, e, n);
                // System.out.println("Original symbol: " + asciiOfChar + ", Encoded symbol: " + encodedSymbol);
            }

            System.out.println(msg);
        } catch (IOException ex) {
            System.out.println("Private key could not be read: " + ex);
        }
    }

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
}
