package quicksort;

import java.util.Arrays;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        int[] inputArray = {12, 81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4};
        quickSort(inputArray, 0, inputArray.length - 1);

        System.out.println((Arrays.toString(inputArray)));
    }

    public static void quickSort(int[] inputArray, int p, int r) {
        if (p < r) {
            // q is the index of the pivot
            int q = partition( inputArray, p, r);

            // left window
            quickSort(inputArray, p, q - 1);

            // right window
            quickSort(inputArray, q + 1, r);
        }
    }

    public static int partition(int[] inputArray, int p, int r) {
        // set pivot to the last value in the array
        int x = inputArray[r];

        // left border of "frame", consisting of i and j
        // it's ok that this starts at -1
        int i = p - 1;

        // right border of frame starts at p (first position)
        // as right border proceeds, see if we need to move up left border
        // if we move up left border (i.e. if we need to put a value to the left of the pivot)
        // flip the values at i and j positions
        for (int j = p; j <= r - 1; j++) {
            if (inputArray[j] <= x) {
                // move i up first, because i is currently on a "sorted" value
                i++;

                // then swap
                int temp = inputArray[i];
                inputArray[i] = inputArray[j]; // inputArray[j] is the value that needs to go to the left of the pivot
                inputArray[j] = temp;
            }
            // only move up left border if we need to
            // otherwise just keep incrementing j (right border)
        }
        // if we're at the point where inputArray[j] is greater than the pivot OR
        // if we're at the point where we've reached the pivot
        // swap pivot with i + 1, where inputArray[i] is still a value that needs to be to the left of the pivot's final position
        int temp = inputArray[i + 1];
        inputArray[i + 1] = inputArray[r];
        inputArray[r] = temp;

        // return the index of the pivot
        return i + 1;
    }
}
