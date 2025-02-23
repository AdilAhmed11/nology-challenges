package io.nology.j5_arrays_extended;

import java.util.Random;

public class Challenge {
    public Challenge() {
    }

    /**
     * A method to initialise a 2D array with random integers (0-99) and print it in
     * matrix format.
     *
     * @param rows    the number of rows in the 2D array
     * @param columns the number of columns in the 2D array
     * @return 2D array in the console
     *         Example Output:
     *         14 73 28 42
     *         39 91 19 46
     *         67 34 89 75
     */
    public void print2DArray(int rows, int columns) {
        Random rand = new Random();
        int[][] array = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = rand.nextInt(100);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * Finds and prints the maximum element in each row of a 2D array.
     *
     * @param array the 2D array of integers
     *              14 73 28 42
     *              39 91 19 46
     *              67 34 89 75
     * @return the maximum element in each row of the arrat, printed one under the
     *         other
     *         Example output:
     *         73
     *         91
     *         89
     */
    public void findMaxInRows(int[][] array) {

        return;
    }

    /**
     * Sorts a 2D array by a specified column and prints the sorted array.
     * 
     * Entered array elements:
     * 14 73 28 42
     * 39 91 19 46
     * 67 34 89 75
     * Column index to sort by: 1
     * Sorted array:
     * 14 34 28 42
     * 39 73 19 46
     * 67 91 89 75
     * 
     * HINT: look into java.util.Comparator;
     *
     * @param array       the 2D array of integers
     * @param columnIndex the index of the column to sort by
     * @throws IllegalArgumentException ("Invalid column index") if the sort index
     *                                  is invalid
     */
    public void sortByColumn(int[][] array, int columnIndex) {
        return;
    }
}
