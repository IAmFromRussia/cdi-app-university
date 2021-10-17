package implementations;

import Jama.Matrix;
import annotations.Minor;
import interfaces.IRankService;

@Minor
public class MinorImpl implements IRankService {
	@Override
	public int getMatrixRank(double[][] matrix, int n, int m) {
		return new Matrix(matrix).rank();
	}
}
