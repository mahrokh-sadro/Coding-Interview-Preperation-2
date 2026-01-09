// Merge two sorted arrays into a new sorted array
public int[] merge(int[] a, int[] b) {
    int i = 0, j = 0, k = 0;
    int[] res = new int[a.length + b.length];

    // Merge while both arrays have elements
    while (i < a.length && j < b.length) {
        if (a[i] <= b[j]) {
            res[k++] = a[i++];
        } else {
            res[k++] = b[j++];
        }
    }

    // Copy remaining elements from a
    while (i < a.length) {
        res[k++] = a[i++];
    }

    // Copy remaining elements from b
    while (j < b.length) {
        res[k++] = b[j++];
    }

    return res;
}
//Time 
// o(m+n)
//Space 
// o(m+n)