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
        /*if (log.isDebugEnabled()) {
            log.debug("Hello, world!");
        }*/

        Random random = new Random();
        List<Double> mas1 = new ArrayList<>();
        List<List<Double>> mas  = new ArrayList<>();

        int K = 1000;
        int N = 1000;
        for(int i=0; i<K; i++)
        {
            for(int j=0; j<N; j++)
            {
                mas1.add(random.nextDouble());
            }
            mas.add(mas1);
        }

        CalculateFunction result = new CalculateFunction(mas, K, 5, 2,10);


        for(int i=0; i<K; i++)
        {
            for(int j=0; j<N; j++) {
                if (log.isDebugEnabled()) {
                    log.debug(mas.get(i).get(j));
                }
            }

        }
    }

}
