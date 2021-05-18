import java.util.List;

public class RSA {


    private static long publicKey[] = {0,0};
    private static long privateKey[] = {0,0};
    private static long p;
    private static long q;
    private long moduloN = 0;
    private long totiente = 0;
    private long expE = 0;
    private long expD = 0;

    public RSA(){

        RandomNumber r = new RandomNumber();

        List<Long> primes = r.Generate(2);
        this.p = primes.get(0);
        this.q = primes.get(1);
        this.moduloN = CalculateN(p, q);
        this.totiente = CalcularTotiente(p, q);
        this.expE = r.FPND(totiente);
        this.expD = CalculateExpD(expE, totiente);
        this.publicKey[0] = expE;
        this.publicKey[1] = moduloN;
        this.privateKey[0] = expD;
        this.privateKey[1] = moduloN;

    }

    long CalculateN(long p, long q){

        return p * q;

    }

    long CalcularTotiente (long p, long q){

        long totiente;

        totiente = (p-1) * (q-1);

        return totiente;

    }

    long CalculateExpD (long exp, long totiente){

        long result = 1;

        while (true){
            if (exp * result % totiente == 1 && exp!=result){
                return result;
            }
            result++;
        }

    }

    /*long CalculaMDC(long a, long b) {

        long result = 0;
        while (b != 0) {
            result = a % b;
            a = b;
            b = result;
        }

        return a;
    }*/


}
