package implementations;

import annotations.Gauss;
import interfaces.IRankService;

@Gauss
public class GaussImpl implements IRankService {
	@Override
	public int getMatrixRank(double[][] matrix, int n, int m) {
		int rowsCounter = 0;
		int limit = Math.min(n, m);


		outer:
		for (double[] row : matrix) {

			for (int i = 0; i < limit; i++) {
				if (Math.abs(row[i]) > 1.0e-14) {
					continue outer;
				}
			}
			rowsCounter++;
		}

		return limit - rowsCounter - 1;
	}
}
