import java.math.BigInteger;
import java.util.Map;

/**
 * Created by herna on 10/15/2016.
 */
public class PoissonDistribution {
    private final double e = 2.718281;
    private double alpha;
    private Factorial get_fact;
    PoissonDistribution(double a){
        this.alpha = a;
        this.get_fact = new Factorial();
    }

    /***********************************************************************
     *                      getPoisson()
     *          Calculate and return the poisson distribution of the given
     *          input value alpha
     * @param x
     * @return
     */
    public double getPoisson(int x){
        BigInteger x_fact = get_fact.getFactorial(x);
        double numerator = Math.pow(e, -alpha) * Math.pow(alpha,x);
        return numerator / x_fact.intValue();
    }


    //setter
    public void setAlpha(double a){
        this.alpha = a;
    }
    //getters
    public double getE(){
        return this.e;
    }
    public double getAlpha(){
        return this.alpha;
    }
}
