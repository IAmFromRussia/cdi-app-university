package component;

import annotations.Minor;
import annotations.Timer;
import interfaces.IRankService;
import lombok.*;

import javax.inject.Inject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatrixCustom {
	public double[][] matrix;

	@Inject
	@Minor
	private IRankService rankService;

	@Timer
	public int getRank() {
		return rankService.getMatrixRank(this.getMatrix(), 3, 3);
	}
}
