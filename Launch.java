import java.util.Scanner;

/**
 * Created by herna on 10/14/2016.
 */
public class Launch {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Chose operation: press 1 to calculate a probability distibution");
        int n = in.nextInt();
        if(n == 1){
            getBinomialDistribution();
        }
    }

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
            System.out.print("Value is: " + bd.run(x));

            System.out.println("press 1 to do another trial or 2 to exit: ");
            int choice = in.nextInt();
            if(choice != 1 ){
                cont = 0;
            }
        }
    }
}
