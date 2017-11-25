package math;

import math.calculate.CalculateFunction;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main
{
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        if (log.isDebugEnabled()) {
            log.debug("Hello, world!");
        }

        Random random = new Random();
        List<Double> mas1 = new ArrayList<>();
        List<List<Double>> mas  = new ArrayList<>();
        List<List<Double>> out = new ArrayList<>();

        int K = 15;
        int N = 15;
        for(int i=0; i<K; i++)
        {
            for(int j=0; j<N; j++)
            {
                double a = random.nextDouble();
                if (log.isDebugEnabled()) {
                    log.debug("Вводимое число: "+ a);
                }
                mas1.add(a);
            }
            mas.add(mas1);
        }

        CalculateFunction result = new CalculateFunction(mas, K, 5, 2,10);
        out = result.result();

        for(int i=0; i<K; i++)
        {
            for(int j=0; j<N; j++) {
                if (log.isDebugEnabled()) {
                    log.debug("mas (" + i +", " + j + ") - " +  out.get(i).get(j));
                }
            }

        }
    }

}
