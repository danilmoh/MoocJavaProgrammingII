package validating;

public class Calculator {

    public int factorial(int num) {
        if(num < 0) {
            throw new IllegalArgumentException("the argument should be positive!");
        }
        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        
        if(isNegative(setSize) || isNegative(subsetSize) || subsetSize > setSize) {
            throw new IllegalArgumentException("the arguments should be positive");
        }

        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
    
    public static boolean isNegative(int arg) {
        if(arg < 0) {
            return true;
        } else { 
            return false;
        }
    }
}
