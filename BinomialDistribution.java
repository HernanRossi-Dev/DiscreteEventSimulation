import java.math.BigInteger;
import java.util.Map;

/**
 * Created by herna on 10/14/2016.
 */
public class BinomialDistribution {
    private int n;
    private BigInteger n_factorial;
    private double p;
    BinomialDistribution(int nin, double pin) {
        n = nin;
        p = pin;
        n_factorial = calculateFactorial(n);

    }

    /***********************************************************************
     *                  run(x)
     *                  calculate the binomial distribution for x successes in
     *                  n trials with success probability p and failure 1-p
     * @param x
     * @return
     */
    public double run(int x){
        double result =0.0;
        //run summation operation
        for(int i =0 ; i <=x ; i++) {

            BigInteger x_factorial = calculateFactorial(i);
            System.out.println(" x factorial is: " + x_factorial);
            System.out.println("n and i are: " + n + " " + i);
            BigInteger k_factorial = calculateFactorial(n - i);
            System.out.println("k factorial is: " + k_factorial);
            BigInteger choose =  n_factorial.divide( (x_factorial.multiply(k_factorial)));
            double p_to_x = Math.pow(p, i);
            double q_to_n_minus_x = Math.pow(1 - p, n - i);
            result += (choose.intValue()* p_to_x * q_to_n_minus_x);
        }
        return 1-result;
    }

    /**************************************************************************
     *                      calculateFactorial(n)
     *                      Calculate the factorial of the input n
     * @param n
     * @return
     */
    public BigInteger calculateFactorial(int n) {
        System.out.println("n is: " + n);
        if(n == 0){
            return new BigInteger("1");
        }
        BigInteger factorial = new BigInteger("1");
        for(int i = 1; i <= n; i++){
            BigInteger bi = BigInteger.valueOf(i);
            factorial = factorial.multiply(bi);
            //System.out.println("factorial is: " + factorial);
        }
        return factorial;
    }
    // Program getters
    public int getN(){
        return this.n;
    }
    public double getP(){
        return this.p;
    }
    public BigInteger getN_factorial(){ return this.n_factorial;}

    //program setters
    public void setN(int nin){
        this.n = nin;
        this.n_factorial = calculateFactorial(n);
    }
    public void setP(int pin){
        this.p = pin;
    }

}
