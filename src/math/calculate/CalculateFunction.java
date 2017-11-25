package math.calculate;

import math.bigfunctional.MathBig;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalculateFunction
{

    private static final Logger log = Logger.getLogger(CalculateFunction.class);

    private double gamma = 1;
    private int c = 2;
    private int K;
    private int alpha;
    private int N;
    private int deltaT;

    private Random random = new Random();
    private List<List<Double>> inputMas = new ArrayList<>();
    private List<List<Double>> outP = new ArrayList<>();
    CalculateDeltaAndN coeff;

    public CalculateFunction(List<List<Double>> inputMas, int k, int alpha, double gamma, int tau)
    {

        this.inputMas = inputMas;
        coeff = new CalculateDeltaAndN(k, alpha);
        this.K = k;
        this.alpha = alpha;
        this.gamma = gamma;

        this.N = coeff.calculateN(tau);
        this.deltaT = coeff.calculateDelta();


       for(int i=0; i< inputMas.size(); i++) {
            ArrayList<Double> mas = new ArrayList<>();
            for (int j = 0; j < inputMas.size(); j++) {
                mas.add((double) 0);
            }
            outP.add(mas);
        }

    }


    public List<List<Double>> result()
    {
        for(int k=0; k<K; k++)
        {
            for(int t=0; t<N; t+=deltaT)
            {
                for(int s=0; s<K; s++)
                {
                    BigInteger c1 = MathBig.addNextDiv(k, s);
                    BigInteger c2 = MathBig.addNextDiv(k, s, alpha);
                    BigInteger pow = MathBig.returnBigInteger(Math.pow(-1,s));
                    BigInteger coeff = c1.multiply(c2.multiply(pow));

                    Double coeff1 = Double.valueOf(String.valueOf(coeff));
                    Double exp = Math.exp(-(2*s+alpha+1)*c*gamma*inputMas.get(k).get(t)/2)*coeff1;

                    Double result = outP.get(k).get(t)+exp;
                    outP.get(k).set(t, result);
                }
            }
        }
        return outP;
    }


}
