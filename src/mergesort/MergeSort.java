package mergesort;

/**
 *
 */
public class MergeSort {
    public static void sort(int inputArray[]) {
        sort(inputArray, 0, inputArray.length - 1);
    }

    public static void sort(int inputArray[], int start, int end) {
        // keep calling sort, generating smaller and smaller "windows"
        // until the window is big enough only for 1 entry
        // then
        if (end <= start) {
            return;
        }

        // Cut current window in half
        int mid = (start + end) / 2;

        // sort on new left array
        sort(inputArray, start, mid);
        // sort on new right array
        sort(inputArray, mid + 1, end);

        // merge left and right
        merge(inputArray, start, mid, end);
    }

    // inputArray is the original, full-length array. We pass in more than we alter
    // start is the left boundary of the "window" - is an index
    // end is the right boundary of the "window" - is an index
    // merge() recursively break down into smaller and smaller "windows"
    // as it is recursively called by sort
    // as each run completes, we go down the stack to biggger and bigger "windows"
    // which are not left aligned
    // Create a temporary array for the current window - write that array to the appropriate pos on inputArray
    public static void merge(int inputArray[], int start, int mid, int end) {
        // must account for first marker being pos 0
        int tempArray[] = new int[end - start + 1];

        // index counter for l array
        int leftMarker = start;
        // index counter for r array
        int rightMarker = mid + 1;
        // index counter for temporary array
        int k = 0;

        // while L isn't past midpoint and R isn't past end
        // fill out tempArray based on which value is higher
        while (leftMarker <= mid && rightMarker <= end) {
            if (inputArray[leftMarker] < inputArray[rightMarker]) {
                tempArray[k] = inputArray[leftMarker];
                leftMarker = leftMarker + 1;
            } else {
                tempArray[k] = inputArray[rightMarker];
                rightMarker = rightMarker + 1;
            }
            k = k + 1;
        }

        // Only one condition must be true to break out of above loop
        // we could theoretically make it to the end of left array
        // without making it to the end of right array
        if (leftMarker <= mid) {
            while (leftMarker <= mid) {
                tempArray[k] = inputArray[leftMarker];
                leftMarker = leftMarker + 1;
                k = k + 1;

            }
        } else if (rightMarker <= end) {
            while (rightMarker <= end) {
                tempArray[k] = inputArray[rightMarker];
                rightMarker = rightMarker + 1;
                k = k + 1;
            }
        }

        // copy over the temp array into inputArray
        for (int i = 0; i < tempArray.length; i++) {
            // we add "start" to i so that
            // we only write to the "window"'s location
            // and the window frame will move from left to right and expand
            // as the recursion proceeds
            inputArray[i + start] = tempArray[i];
        }
    }
}
