import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        printZeckendorf(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
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

        for(int i = getFibonacciArray.size(); i < maxGenerated; i++) {
            getFibonacciArray.add(getFibonacciArray.get(i - 1) + getFibonacciArray.get(i - 2));
        }

        return getFibonacciArray;
    }
}

