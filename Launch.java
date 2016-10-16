import java.util.Scanner;

/**
 * Created by herna on 10/14/2016.
 */
public class Launch {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Choose operation: press 1 to calculate a probability distribution");
        int n = in.nextInt();
        if(n == 1){
            System.out.println("Choose operation:\npress 1 to get Binomial distribution");
            System.out.println("press 2 to get Poisson distribution");
            n = in.nextInt();
            if(n == 1) {
                getBinomialDistribution();
            }else if(n == 2){
                getPoisson();
            }else{
                System.out.print("No valid choice given exiting.");
                System.exit(0);
            }
        }
    }

    /**********************************************************************************
     *              getPoisson()
     *              calculate the Poisson distribution probability p(x) for a given
     *              integer value x based on the provided alpha value
     */
    public static void getPoisson(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input value for alpha: ");
        double alpha = in.nextDouble();
        PoissonDistribution p_dist = new PoissonDistribution(alpha);
        System.out.println("Input value for x: ");
        int x = in.nextInt();
        double result = p_dist.getPoisson(x);
        System.out.println("The Poisson probability p(x) given alpha " + alpha + " is: " + result);

    }


    /*******************************************************************************
     *
     */
    public static void getBinomialDistribution(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input value for the number of trials n: ");
        int n = in.nextInt();
        System.out.println("Input value for the probability of success p: ");
        double p = in.nextDouble();
        BinomialDistribution bd = new BinomialDistribution(n,p);
        int cont = 1;
        while(cont == 1) {
            System.out.println("What is the value of x that you would like to calculate for P( X <= x)? ");
            int x = in.nextInt();
            double result = bd.run(x);
            System.out.println("Value is: " + result);
            System.out.println("The expected value E(X) is: " + n*p);
            System.out.println("The the variance V(X) is: " + n*p*(1-p));
            System.out.println("press 1 to do another trial or 2 to exit: ");
            int choice = in.nextInt();
            if(choice != 1 ){
                cont = 0;
            }
        }
    }
}
