class Solution {
    public void rearrange(int[] arr, int x) {
        // Convert int[] to Integer[] for comparator sorting
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        // Sort using comparator
        java.util.Arrays.sort(temp, (a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            return diffA - diffB;
        });

        // Copy back to arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    // Test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {10, 5, 3, 9, 2};
        int x = 7;

        sol.rearrange(arr, x);

        for (int val : arr) {
            System.out.print(val + " ");
        }
        // Output: 5 9 10 3 2
    }
}
