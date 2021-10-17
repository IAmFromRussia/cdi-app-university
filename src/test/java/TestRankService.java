import component.MatrixCustom;
import implementations.DeterminantImpl;
import implementations.GaussImpl;
import implementations.MinorImpl;
import interfaces.IRankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

class TestGetRankMethodsImplementations {

	IRankService determinantImpl;
	IRankService gaussImpl;
	IRankService minorImpl;
	MatrixCustom matrixCustomObj;

	double[][] mat =
			{
					{10, 20, 10},
					{-20, -30, 10},
					{30, 50, 0}
			};

	@BeforeEach
	public void setUp() {
		determinantImpl = (IRankService) new DeterminantImpl();
		gaussImpl = (IRankService) new GaussImpl();
		minorImpl = (IRankService) new MinorImpl();

		matrixCustomObj = new MatrixCustom();
		matrixCustomObj.matrix = mat;
	}

	@RepeatedTest(1)
	@DisplayName("Determinant implementation")
	public void checkDeterminantImpl() {
		assertEquals(2, determinantImpl.getMatrixRank(matrixCustomObj.matrix, 3, 3), "Matrix rank should be equals 2");
	}

	@RepeatedTest(1)
	@DisplayName("Gauss implementation")
	public void checkGaussImpl() {
		assertEquals(2, gaussImpl.getMatrixRank(matrixCustomObj.matrix, 3, 3), "Matrix rank should be equals 2");
	}

	@RepeatedTest(1)
	@DisplayName("Minor implementation")
	public void checkMinorImpl () {
		assertEquals(2, minorImpl.getMatrixRank(matrixCustomObj.matrix, 3, 3), "Matrix rank should be equals 2");
	}
}
