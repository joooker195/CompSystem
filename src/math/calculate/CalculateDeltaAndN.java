package math.calculate;

import math.Main;
import math.bigfunctional.MathFactorial;
import math.bigfunctional.MathBig;
import org.apache.log4j.Logger;

import java.math.BigInteger;

public class CalculateDeltaAndN
{

    private static final Logger log = Logger.getLogger(CalculateDeltaAndN.class);

    private double sigma = 0.3;
    private final int C = 2;
    private int k;
    private int alpha;
    BigInteger p = BigInteger.ONE;


    public CalculateDeltaAndN(int k, int alpha)
    {

        this.k = k;
        this.alpha = alpha;
    }

    private void calculateP()
    {
        for(int s=0; s<k; s++)
        {
            BigInteger c1 = MathBig.addNextDiv(k, s);
            BigInteger c2 = MathBig.addNextDiv(k, s, alpha);

           /* if (log.isDebugEnabled()) {
                log.debug(" c1 = " +c1 + " c2 = "+c2);
            }*/

            BigInteger pow = MathBig.returnBigInteger(Math.pow(-1, s));

            /*if (log.isDebugEnabled()) {
                log.debug(" pow = " +pow);
            }*/

            BigInteger bigs = MathBig.returnBigInteger(2*s);
            BigInteger bigalpha = MathBig.returnBigInteger(alpha);

            /*if (log.isDebugEnabled()) {
                log.debug(" bigs = " + bigs + " bigalpha = "+bigalpha );
            }*/

            p = c1.multiply(c2).multiply(pow).multiply(bigs.add(bigalpha).add(MathBig.returnBigInteger(1)));
            p = p.pow(2);

          /*  if (log.isDebugEnabled()) {
                log.debug(" p = " +p);
            }*/
        }

        double coeff = Math.pow(C,2)*Math.pow(alpha, 2)/4;
        BigInteger bigcoeff  = MathBig.returnBigInteger(coeff);

       /* if (log.isDebugEnabled()) {
            log.debug(" coeff = " + coeff + " bigcoeff = "+bigcoeff );
        }*/

        p = p.multiply(bigcoeff);
/*        if (log.isDebugEnabled()) {
            log.debug(" p = " +p);
        }*/
    }
    public int calculateDelta()
    {
         calculateP();
         /*if (log.isDebugEnabled()) {
            log.debug("sigma = "+sigma+ " p = " +p);
         }*/
         BigInteger coeff = MathBig.returnBigInteger(8*sigma);
         BigInteger modal =  p.abs();
         BigInteger bigDelta = MathFactorial.sqrt(coeff.remainder(modal));
         Integer delta = Integer.valueOf(String.valueOf(bigDelta));
         return delta;
    }


    public int calculateN(int tau)
    {
        int n = 0;
        int delta = calculateDelta();
        n = (int) Math.abs(tau/delta + 0.5);
        return n;
    }


}
