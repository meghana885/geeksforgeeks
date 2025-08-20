class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int left = 0, right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midVal = getValue(mat, mid, m);
            if (midVal == x) return true;

            int leftVal = getValue(mat, left, m);
            int rightVal = getValue(mat, right, m);

            // Left half sorted
            if (leftVal <= midVal) {
                if (x >= leftVal && x < midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // Right half sorted
            else {
                if (x > midVal && x <= rightVal) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    // helper to convert 1D index into 2D matrix value
    private int getValue(int[][] mat, int idx, int m) {
        int row = idx / m;
        int col = idx % m;
        return mat[row][col];
    }
}
