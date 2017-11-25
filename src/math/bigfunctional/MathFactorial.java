package math.bigfunctional;

import math.calculate.CalculateDeltaAndN;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.util.HashMap;

public class MathFactorial
{
    private static final Logger log = Logger.getLogger(MathFactorial.class);
    static HashMap<Integer,BigInteger> cache = new HashMap<Integer,BigInteger>();

    public static BigInteger factorial(int n) {
        BigInteger ret = BigInteger.ONE;
        try {
            if (n == 0) return BigInteger.ONE;
            if (null != (ret = cache.get(n))) return ret;
            ret = BigInteger.valueOf(n).multiply(factorial(n - 1));
            /*if (log.isDebugEnabled()) {
                log.debug("ret = "+ ret);
            }*/
            cache.put(n, ret);
        } catch (StackOverflowError e) {
            if (log.isDebugEnabled()) {
                log.debug(e.fillInStackTrace());
            }
        }
        finally
        {
            return ret;

        }
    }

    public static void clear()
    {
        cache = new HashMap<Integer,BigInteger>();
    }

    public static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while(b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
            else a = mid.add(BigInteger.ONE);
        }
        return a.subtract(BigInteger.ONE);
    }
}
