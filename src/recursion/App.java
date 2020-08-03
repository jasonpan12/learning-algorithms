package recursion;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println(recursiveLinearSearch(new int[] {4,48,4,28,34,76,9,3}, 0, 28));
    }

    public static void reduceByOne(int n) {
        // Base case - when recursion should stop
        if (n >= 0) {
            reduceByOne(n - 1);
        }

        // prints out in reverse because of call stack behavior
        // sout is not hit until the recursion completes
        // then n is printed in reverse order as reduceByOnes complete, from the top of the stack down
        System.out.println("Completed Call: " + n);
    }

    // a is array
    // i is initial
    // x is search term
    public static int recursiveLinearSearch(int[] a, int i, int x) {
        // Base case - stop if we go past the length of the array
        if (i > a.length - 1) {
            return -1;
        } else if (a[i] == x) {
            // Return the index value when we find the search term
            return i;
        } else {
            System.out.println("index at: " + i);
            return recursiveLinearSearch(a, i + 1, x);
        }
    }
}

// Linear Search HW
// Procedure RECURSIVE LINEAR SEARCH (A, i, x)
// Inputs: same as linearSearch but with the added parameter i
// Output: The index of an element matching x in the subarray from A[i]
// through A[n], or -1 if x is not found in the array
//
// 1. If i > n, then return -1 (iterated past length array)
// 2. Else if A[i] == x, then return i
// Else return RECURSIVE-LINEAR-SEARCH (A, i + 1, x)

