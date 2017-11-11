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
/*
        if (log.isDebugEnabled()) {
            log.debug("kFact = " +MathFactorial.factorial(k));
            log.debug("sFact = " + MathFactorial.factorial(s));
            log.debug("k-sFact = "+ MathFactorial.factorial(k-s));
        }
*/


        return MathFactorial.factorial(k).divide(MathFactorial.factorial(s).multiply(MathFactorial.factorial(k-s)));
    }

    public static BigInteger addNextDiv(int k, int s, int alpha)
    {
        return MathFactorial.factorial(k+s+ alpha).divide(MathFactorial.factorial(k).multiply(MathFactorial.factorial(s+ alpha)));
    }

    public static BigDecimal returnBigDecimal(BigInteger num)
    {
        Long longnum = Long.valueOf(num.toString());
        return BigDecimal.valueOf(longnum);
    }

    public static BigDecimal returnBigDecimal(double num)
    {
        Long longnum = Long.valueOf(String.valueOf(num));
        return BigDecimal.valueOf(longnum);
    }

    public static BigInteger returnBigInteger(double num)
    {
        Long longnum = Long.valueOf(String.valueOf(Integer.valueOf((int)num)));
        return BigInteger.valueOf(longnum);
    }

}
