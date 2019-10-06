import prog_01.Sieve;

public class Main {

    private static Sieve sieve;

    public static void main(String[] args) {
        sieve = new Sieve();
        System.out.println(sieve.sieve(1000));
    }
}
