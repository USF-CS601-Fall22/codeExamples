package multithreading.basics;

/**
 * Creates NUM_ROWS threads to search for the maximum value of a large matrix. Each
 * thread searches for max in one row of the matrix. Based on the example from
 * http://www.ibm.com/developerworks/java/tutorials/j-threads/j-threads.html
 */
public class SolvingForMax {

    public final static int NUM_ROWS = 10;

    /** Inner class that represents a worker thread that computes the maximum in the given 1D array */
    private static class WorkerThread extends Thread {
        double max = Double.MIN_VALUE;
        double[] row;

        public WorkerThread(double[] row) {
            this.row = row;
        }

        /** Find the maximum value in the given row
         *
         */
        @Override
        public void run() {
            for (int i = 0; i < row.length; i++)
                max = Math.max(max, row[i]);
        }

        /**
         *
         * @return maximum for this row
         */
        public double getMax() {
            return max;
        }
    }

    public static void main(String[] args) {
        double [][] bigMatrix = generateBigMatrix(NUM_ROWS, 1000000);

        WorkerThread[] threads = new WorkerThread[bigMatrix.length];
        double max = Double.MIN_VALUE;

        // Give each thread a row of the matrix to work with
        for (int i = 0; i < NUM_ROWS; i++) {
            threads[i] = new WorkerThread(bigMatrix[i]);
            threads[i].start();
        }

        // Wait for each thread to finish
        try {
            for (int i = 0; i < NUM_ROWS; i++) {
                threads[i].join();
                max = Math.max(max, threads[i].getMax());
            }
        } catch (InterruptedException e) {
            System.out.println("The thread was interrupted. ");
        }

        System.out.println("Maximum value was " + max);
    }

    /**
     *
     * @param n the number of rows in the matrix
     * @param m the number of columns in the matrix
     * @return the matrix n by m of random values in the range from 0 to 1.
     */
    public static double[][] generateBigMatrix(int n, int m) {
        double[][] matrix = new double[n][m];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Math.random();
                // System.out.print(matrix[row][col] + "\t");
            }
            // System.out.println();

        }
        return matrix;

    }
}
