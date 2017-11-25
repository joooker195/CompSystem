package math.bigfunctional;

import math.calculate.CalculateDeltaAndN;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MathBig
{
    private static final Logger log = Logger.getLogger(MathBig.class);


    public static BigInteger addNextDiv(int k, int s)
    {
        BigInteger res = BigInteger.ONE;
        try {

            MathFactorial.clear();
            BigInteger fk =  MathFactorial.factorial(k);
            if (log.isDebugEnabled()) {
                log.debug("k = "+k+" fk = " + fk);
            }

            MathFactorial.clear();
                       BigInteger fs = MathFactorial.factorial(s);
            if (log.isDebugEnabled()) {
                log.debug("s = "+s+" fs = " + fs);
            }

            MathFactorial.clear();
            int ks = k-s;
            if(ks<0)
            {
                ks=ks*(-1);
            }
            BigInteger fks = MathFactorial.factorial(ks);
            if (log.isDebugEnabled()) {
                log.debug("k - s = " + ks +" fks = "+ fks);
            }

            res = fk.divide(fs.multiply(fks));
            if (log.isDebugEnabled()) {
                log.debug("Высчитываем c1 = " + res);
            }
            return res;
        }
        catch (Exception e)
        {
            if (log.isDebugEnabled()) {
                log.debug(e.fillInStackTrace());
            }
        }
        return res;
    }

    public static BigInteger addNextDiv(int k, int s, int alpha)
    {
        MathFactorial.clear();
        BigInteger fk =  MathFactorial.factorial(k);
        if (log.isDebugEnabled()) {
            log.debug("k = "+k+" fk = " + fk);
        }

        MathFactorial.clear();
        BigInteger fksa = MathFactorial.factorial(k+s+alpha);
        if (log.isDebugEnabled()) {
            log.debug("k+s+alpha = "+(k+s+alpha)+" fksa = " + fksa);
        }

        MathFactorial.clear();
        BigInteger fsa = MathFactorial.factorial(s+alpha);
        if (log.isDebugEnabled()) {
            log.debug("s+alpha = " + (s+alpha) +" fsa = "+ fsa);
        }

        BigInteger res = fksa.divide(fk.multiply(fsa));
        if (log.isDebugEnabled()) {
            log.debug("Высчитываем c2 = " + res);
        }
        return res;
    }

    public static BigInteger returnBigInteger(double num)
    {
        Long longnum = Long.valueOf(String.valueOf(Integer.valueOf((int)num)));
        return BigInteger.valueOf(longnum);
    }

}
