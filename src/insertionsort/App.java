package insertionsort;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        int myArray[] = insertionSort(new int[]{9, 8, 99, 110, 8, 87, 637, 8, 3, 13, 87, 12, 99});

        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
    }

    public static int[] insertionSort(int[] a) {
        // loop over each element in the array
        for (int i = 1; i <= a.length - 1; i++) {
            // Set current element
            // Start at the *second* item in the array
            int element = a[i];

            // Save the "previous" item in the array
            int j = i - 1;

            // while previous item is greater than current element
            while (j >= 0 && a[j] > element) {
                // move the item to the right
                // this overrides current, but current
                // is stored at element
                a[j + 1] = a[j];

                // decrement j
                j--;

                // until the algo finds an item less than current element
            }

            // insert the element when
            // we find an item less than current
            a[j + 1] = element;
        }

        return a;
    }
}
