package binarysearch;

/**
 *
 */
public class App {
    // binary search only works on sorted arrays
    
    public static void main(String[] args) {
        System.out.println(recursiveBinarySearch(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,18},0, 10, 9));
    }

    // returns index position of match
    public static int binarySearch(int[] a, int x) {
            int p = 0;
            int r = a.length;

            while (p <= r) {
                // initialize midpoint
                int q = (p + r) / 2;

                if (a[q] == x) {
                    return q;
                } else if (a[q] > x) {
                    // move right bound down to q - 1
                    r = q - 1;
                }  else {
                    // move left bound up to q
                    p = q + 1;
                }
            }

            return -1;
        }

    public static int recursiveBinarySearch(int a[], int p, int r, int x) {
        int q = (p + r) / 2;

        if (a[q] == x) {
            return q; // found the event
        } else if (p > r){
            return -1;
        } else if (a[q] > x) {
            // move right bound down to q - 1
            return recursiveBinarySearch(a, p, q - 1, x);
        }  else {
            // move left bound up to q
            return recursiveBinarySearch(a, q + 1, r, x);
        }
    }
}
