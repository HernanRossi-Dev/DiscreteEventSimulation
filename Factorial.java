import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by herna on 10/15/2016.
 *
 * Calculate the factorial of the input value returning a BigInteger value
 */
public class Factorial {
    private HashMap<Integer, BigInteger> memory;
    Factorial(){
        //default constructor
        memory = new HashMap<>();
        memory.put(0, new BigInteger("1"));
        memory.put(1, new BigInteger("1"));
    }

    /*********************************************************************
     *                      getFactorial()
     *             Calculate and return the factorial of the input value n
     *             in BigInteger: check if the value has been calculated
     *             already and stored in the memory Hashmap first
     * @param n
     * @return
     */
    public BigInteger getFactorial(int n){
        Integer value = n;
        //check if value has already been calculated and stored
        if(memory.containsKey(value)){
            return memory.get(value);
        }
        if(n == 0 || n == 1){
            return memory.get(0);
        }
        BigInteger factorial = memory.get(1);
        for(int i = 2; i <= n; i++){
            //Check if the value of i! has already been calculated and stored
            if(memory.containsKey(i)){
                factorial = memory.get(i);
            }
            else {
                BigInteger bi = BigInteger.valueOf(i);
                factorial = factorial.multiply(bi);
                memory.put(i, factorial);
            }
        }
        return factorial;
    }
}
