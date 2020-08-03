package selectionsort;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        int [] myArray = selectionSort(new int[]{9, 8, 3, 13, 87, 12, 99});
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
    }

    public static int[] selectionSort(int a[]) {
        // Loop over each item in the array
        // Starting from i=0
        // for each loop run, check remaining items
        // and move smallest value to "minimum", aka i

        for (int i = 0; i < a.length; i++) {
            // Initialize minimum
            int minimum;
            minimum = i;

            // Search through "rest" of array
            // And store the index of the minimum value
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minimum]) {
                    // Set store the new minimum value
                    minimum = j;
                }
            }

            // Swap the minimum value and i
            // Store whatever's at the beginning of the array
            int temp = a[i];
            a[i] = a[minimum];
            a[minimum] = temp;
        }

        return a;
    }
}
