import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        int firstArgument = 0;
        int secondArgument = 0;

        try {
            firstArgument = Integer.parseInt(args[0]);
            secondArgument = Integer.parseInt(args[1]);
        } catch(ArrayIndexOutOfBoundsException exception) {
            System.out.println("Arguments missing");
            System.exit(-1);
        } catch(NumberFormatException exception) {
            System.out.println("Arguments only accept integers");
            System.exit(-1);
        }
        if (Integer.parseInt(args[0]) < 0 || Integer.parseInt(args[1]) < 0) {
            System.out.println("Argument integers have to be positive numbers");
            System.exit(1);
        }
        printZeckendorf(firstArgument, secondArgument);
    }

    public static void printZeckendorf(int min, int max) {
        ArrayList<Integer> fibonacciArray = getFibonacciArray(max);

        for(int i = min; i <= max; i++ ) {
            System.out.println(i + " - " + convertNumberToZeckendorf(i, fibonacciArray));
        }
    }

    public static String convertNumberToZeckendorf(int number, ArrayList<Integer> fibonacciArray) {
        if(number == 0) {
            return "0 Zeck";
        }

        StringBuilder result = new StringBuilder();
        int sum = 0;
        for (int j = fibonacciArray.size() - 1; j > 0; j--) {
            if (fibonacciArray.get(j) > number) {
                continue;
            } else if ((sum + fibonacciArray.get(j)) > number) {
                result.append("0");
                continue;
            }
            sum += fibonacciArray.get(j);
            result.append("1");
        }
        result.append(" Zeck");
        return result.toString();
    }

    public static ArrayList<Integer> getFibonacciArray(int maxGenerated) {
        ArrayList<Integer> getFibonacciArray = new ArrayList<>();
        getFibonacciArray.add(1);
        getFibonacciArray.add(1);
        getFibonacciArray.add(2);

        if(maxGenerated < 5) {
            maxGenerated = 5;
        }

        for(int i = getFibonacciArray.size(); i < maxGenerated; i++) {
            int sumArrayElements = getFibonacciArray.get(i - 1) + getFibonacciArray.get(i - 2);
            if (sumArrayElements < 0) {
                break;
            }
            getFibonacciArray.add(sumArrayElements);
        }

        return getFibonacciArray;
    }
}


