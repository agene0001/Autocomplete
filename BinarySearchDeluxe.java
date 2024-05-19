import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int low = 0;
        int high = a.length - 1;
        int mid = low + (high - low) / 2;
        int cmp = comparator.compare(a[mid], key);
        if (cmp < 0) {

            return binaryHelp(a, key, comparator, low, mid - 1);
        }
        else if (cmp > 0) {
            return binaryHelp(a, key, comparator, mid + 1, high);
        }
        else {
            int ind = 1;
            int temp = comparator.compare(a[mid - ind], key);
            int val = mid;
            while (temp == 0) {
                val = mid - ind;
                ind++;
            }
            return val;
        }

    }

    private static <Key> int binaryHelp(Key[] a, Key key, Comparator<Key> comparator, int low,
                                        int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = comparator.compare(a[mid], key);
            if (cmp < 0) {

                return binaryHelp(a, key, comparator, low, mid - 1);
            }
            else if (cmp > 0) {

                return binaryHelp(a, key, comparator, mid + 1, high);
            }
            else {
                int ind = 1;
                int temp = comparator.compare(a[mid - ind], key);
                int val = mid;
                while (temp == 0) {
                    val = mid - ind;
                    ind++;
                }
                return val;
            }

        }
        else {
            return -1;
        }
    }

    private static <Key> int binaryHelp1(Key[] a, Key key, Comparator<Key> comparator, int low,
                                         int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = comparator.compare(a[mid], key);
            if (cmp < 0) {
                return binaryHelp1(a, key, comparator, low, mid - 1);
            }

            else if (cmp > 0) {

                return binaryHelp1(a, key, comparator, mid + 1, high);
            }
            else {
                int ind = 1;
                int temp = comparator.compare(a[mid + ind], key);
                int val = mid;
                while (temp == 0) {
                    val = mid + ind;
                    ind++;
                }
                return val;
            }

        }
        else {
            return -1;
        }
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int low = 0;
        int high = a.length - 1;
        int mid = low + (high - low) / 2;
        int cmp = comparator.compare(a[mid], key);
        if (cmp < 0) {
            return binaryHelp1(a, key, comparator, mid + 1, high);
        }
        else if (cmp > 0) {
            return binaryHelp1(a, key, comparator, low, mid - 1);
        }
        else {
            int ind = 1;
            int temp = comparator.compare(a[mid + ind], key);
            int val = mid;
            while (temp == 0) {
                val = mid + ind;
                ind++;
            }
            return val;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

    }
}
