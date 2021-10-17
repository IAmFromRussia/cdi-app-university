import component.MatrixCustom;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Main {

    public static void main(String[] args) {
	    SeContainerInitializer initializer = SeContainerInitializer.newInstance();
	    SeContainer container = initializer.initialize();

	    double[][] mat =
			    {
					    {10, 20, 10},
					    {-20, -30, 10},
					    {30, 50, 0}
			    };

	    MatrixCustom matrix = container.select(MatrixCustom.class).get();
		matrix.setMatrix(mat);

	    System.out.println("Calculation result");
	    System.out.println(matrix.getRank());
    }
}
