package implementations;

import annotations.Determinant;
import interfaces.IRankService;

@Determinant
public class DeterminantImpl implements IRankService {

	static void swap(double[][] matrix, int firstRow, int secondRow, int columnNumber) {
		for (int i = 0; i < columnNumber; i++) {
			double temp = matrix[firstRow][i];
			matrix[firstRow][i] = matrix[secondRow][i];
			matrix[secondRow][i] = temp;
		}
	}

	@Override
	public int getMatrixRank(double[][] matrix, int n, int m) {
		int rank = n;
		for (int row = 0; row < rank; row++) {
			if (matrix[row][row] != 0) {
				for (int col = 0; col < m; col++) {
					if (col != row) {
						double mult = matrix[col][row] / matrix[row][row];
						for (int i = 0; i < rank; i++)
							matrix[col][i] -= mult * matrix[row][i];
					}
				}
			} else {
				boolean reduce = true;
				for (int i = row + 1; i < m; i++) {
					if (matrix[i][row] != 0) {
						swap(matrix, row, i, rank);
						reduce = false;
						break;
					}
				}
				if (reduce) {
					rank--;
					for (int i = 0; i < m; i++)
						matrix[i][row] = matrix[i][rank];
				}
				row--;
			}
		}
		return rank;

	}
}
