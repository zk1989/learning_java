public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Euclidean Algorithm, GCD for 10 and 20: " + euclideanAlgorithm(10, 20));
        System.out.println("Euclidean Algorithm, GCD for 5 and 100: " + euclideanAlgorithm(5, 100));
        System.out.println("Euclidean Algorithm, GCD for 174 and 378463647: " + euclideanAlgorithm(174, 378463647));
        System.out.println("Euclidean Algorithm, GCD for 534560 and 103784: " + euclideanAlgorithm(534560, 103784));

        int[] bbsTable = blumBlumShub(10);
        System.out.println("Blum Blum Shub pseudorandom numbers: ");
        displayTable(bbsTable);

        int[] table = {4, 1, 8, 5};
        selectionSort(table);
        System.out.println("Table sorted by selection sort algorithm: ");
        displayTable(table);
        
        int[] bubbleTable = {6, 70, 1, 5, 90, 100, 3};
        bubbleSort(bubbleTable);
        System.out.println("Table sorted by bubble sort algorithm: ");
        displayTable(bubbleTable);

        System.out.println(fibonacciIterative(7));
        System.out.println(fibonacciRecursive(7));

        int[] quicksortTable = {5, 8, 1, 10, 9, 4, 2, 15, 7, 6};
        System.out.println("Quicksort");
        quickSort(0, quicksortTable.length - 1, quicksortTable);
        displayTable(quicksortTable);
    }

    public static int euclideanAlgorithm(int x, int y) {
        // returns the greatest common divisor
        while (x != y) {
            if (x > y) {
                x = x - y;
            } else if (y > x) {
                y = y - x;
            } else if (y == x) {
                break;
            }
        }
        return y;
    }

    public static int[] blumBlumShub(int n) {
        // returns n pseudorandom numbers
        int xn;
        int[] randomNumbers = new int[n];
        int x0 = 234;
        int p = 2287;
        int q = 3079;
        int N = p * q;

        for (int i = 0; i < n; i++) {
            xn = (x0 * x0) % N;
            randomNumbers[i] = xn;
            x0 = xn;
        }

        return randomNumbers;
    }

    public static void displayTable(int[] table) {
        for (int i : table) {
            System.out.println(i);
        }
    }

    public static void selectionSort(int[] table) {
        // sorts table in-place, from smallest to largest int
        for (int i = 0; i < table.length; i++) {
            int minIndex = findMinIndex(i, table);
            if (i != minIndex) {
                swapValues(i, minIndex, table);
            }
        }
    }

    public static int findMinIndex(int startIndex, int[] table) {
        int minIndex = startIndex;
        for (int i = startIndex; i < table.length; i++) {
            if (table[i] < table[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void swapValues(int i, int j, int[] table) {
        int firstValue = table[i];
        int secondValue = table[j];

        table[i] = secondValue;
        table[j] = firstValue;
    }

    public static void bubbleSort(int[] table){
        // sorts table in-place, from smallest to largest int
        int lastIndex = table.length - 1;
        boolean flag;

        do {
            flag = false;
            for (int i = 0; i < lastIndex; i++) {
                if (table[i] > table[i + 1]) {
                    swapValues(i, i + 1, table);
                    flag = true;
                }
            }
            lastIndex = lastIndex - 1;
        } while(flag);
    }

    public static int fibonacciIterative(int n) {
        // returns value of n-th element of fibonacci sequence - iterative approach
        int[] fib = new int[]{0, 1}; 

        if (n < 2) 
            return fib[n];
        
        for (int i = 2; i <= n; i++){ 
            int tmp = fib[0]; 
            fib[0] = fib[1]; 
            fib[1] = fib[0] + tmp; 
        } 

        return fib[1]; 
    }

    public static int fibonacciRecursive(int n){
        // returns value of n-th element of fibonacci sequence - recursive approach
        System.out.print(n + ", ");

        if (n < 2) 
            return n; 

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2); 
    } 

    
    public static void quickSort(int startIndex, int stopIndex, int[] table) {
        int pivot = stopIndex;

        if (startIndex >= stopIndex) {
            return;
        }

        int leftPointer = startIndex;
        int rightPointer = stopIndex;

        while (leftPointer < rightPointer) {
            while (table[leftPointer] <= table[pivot] && leftPointer < rightPointer) {
                leftPointer = leftPointer + 1;
            }

            while (table[rightPointer] >= table[pivot] && rightPointer > leftPointer) {
                rightPointer = rightPointer - 1;
            }
            swapValues(leftPointer, rightPointer, table);
        }
        swapValues(pivot, rightPointer, table);

        quickSort(0, leftPointer - 1, table);
        quickSort(rightPointer + 1, table.length - 1, table);
    }
}