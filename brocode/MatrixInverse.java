public class MatrixInverse {
    public static void main(String[] args) {
        // Create a 2x2 matrix
        double[][] matrix = {
            {4, 7},
            {2, 6}
        };

        double[][] inverse = invert2x2(matrix);

        if (inverse != null) {
            System.out.println("Inverse matrix:");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.printf("%8.3f ", inverse[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix is singular and cannot be inverted.");
        }
    }

    // Method to find the inverse of a 2x2 matrix
    static double[][] invert2x2(double[][] m) {
        double det = m[0][0] * m[1][1] - m[0][1] * m[1][0];
        if (det == 0) {
            return null; // Singular matrix
        }
        double invDet = 1.0 / det;
        double[][] inv = new double[2][2];
        inv[0][0] =  m[1][1] * invDet;
        inv[0][1] = -m[0][1] * invDet;
        inv[1][0] = -m[1][0] * invDet;
        inv[1][1] =  m[0][0] * invDet;
        return inv;
    }
}
