import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {

    public static List<Long> visited = new ArrayList<Long>();

    public static List<Long> Generate(int n, long leftLimit, long rightLimit)
    {
        List<Long> primes = new ArrayList<>();

        long k = RandomKey(leftLimit, rightLimit);

        while (primes.size() < n)
        {
            boolean prime = IsPrime(k);

            if (prime)
            {
                primes.add(k);
            }
            else
            {
                visited.add(k);
            }

            k = RandomKey(leftLimit, rightLimit);
        }

        return primes;
    }

    public static Long FPND(long x)
    {
        long k = RandomKey(2, x);

        while (true)
        {
            boolean prime = IsPrime(k);

            if (prime)
            {
                if(x % k != 0)
                {
                    return k;
                }
            }
            else
            {
                visited.add(k);
            }

            k = RandomKey(2, x);
        }
    }

    public static boolean IsPrime(long k)
    {
        long sqrt = (long)Math.sqrt(k);

        for (long j = 2; j <= sqrt; j++)
        {
            if (k % j == 0)
            {
                return false;
            }
        }

        return true;
    }

    private static long RandomKey(long leftLimit, long rightLimit)
    {
        long k = LongRandom(leftLimit, rightLimit);
        while (true)
        {
            if (visited.contains(k))
            {
                k = LongRandom(leftLimit, rightLimit);
            }
            else
            {
                return k;
            }
        }
    }

    private static long LongRandom(long leftLimit, long rightLimit)
    {
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

    public static List<Long> Generate(int n)
    {
        return Generate(n, Integer.MAX_VALUE, (long)Integer.MAX_VALUE * 2);
    }

}
