package prog_01_RSA;

import java.math.BigInteger;

public class Prime {

    private BigInteger candidatePrime;
    private final int MILLER_RABIN_ROUNS = 5;

    public Prime(BigInteger bi) {
        candidatePrime = bi;
    }

}
