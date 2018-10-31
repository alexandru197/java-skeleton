package answers;
import static java.lang.Math.*;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		for(int i=0;i<portfolios.length;i++){
			for(int j=1;j<=portfolios.length;j++){
				max  = Math.max (max, portfolios[i] ^ portfolios[j]);
			}
		}
		return max;
	}

}
