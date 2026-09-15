class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int lowerM = 0;
        int higherM = m - 1;
        
        int row = -1;
        while (lowerM <= higherM) {
            int midM = (lowerM + higherM)/2;
            if (target >= matrix[midM][0] && target <= matrix[midM][n - 1]) {
                row = midM;
                break;
            }
            else if (target < matrix[midM][0]) {
                if (midM == 0) break;
                higherM = midM - 1;
            }
            else if (target > matrix[midM][n - 1]) {
                if (midM == m - 1) break;
                lowerM = midM + 1;
            }
        }

        /*
        1 10
        11 20
        21 30
        */
        if (row == -1) return false;

        int lowerN = 0;
        int higherN = n - 1;

        int col = -1;
        while (lowerN <= higherN) {
            int midN = (lowerN + higherN)/2;
            if (target == matrix[row][midN]) {
                return true;
            }
            else if (target < matrix[row][midN]) {
                higherN = midN - 1;
            }
            else if (target > matrix[row][midN]) {
                lowerN = midN + 1;
            }
        }
        /*
        1 2 3 4 5 6 8
        0-----------6
        tgt 7
        */
        return false;

    }
}
