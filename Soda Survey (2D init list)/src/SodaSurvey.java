// 2D array init list demo

import java.text.DecimalFormat;

public class SodaSurvey {
	public static void main(String[] args) {
		int[][] scores = {{3, 4, 5, 2, 1, 4, 3, 2, 4, 4},
						  {2, 4, 3, 4, 3, 3, 2, 1, 2, 2},
						  {3, 5, 4, 5, 5, 3, 2, 5, 5, 5},
						  {1, 1, 1, 3, 1, 2, 1, 3, 2, 4}};
		
		final int SODAS = scores.length;
		final int PEOPLE = scores[0].length;
		
		int[] sodaSum = new int[SODAS];
		float[] sodaAvg = new float[SODAS];
		int[] personSum = new int[PEOPLE];
		float[] personAvg = new float[PEOPLE];
		
		for (int soda = 0; soda < SODAS; soda++)
			for (int person = 0; person < PEOPLE; person++) {
				sodaSum[soda] += scores[soda][person];
				personSum[person] += scores[soda][person];
			}
		
		DecimalFormat fmt = new DecimalFormat("0.#");
		System.out.println("Averages:\n");
		
		for (int soda = 0; soda < SODAS; soda++) {
			sodaAvg[soda] = (float)sodaSum[soda]/PEOPLE;
			
			System.out.println("Soda #" + (soda+1) + ": " + 
					fmt.format(sodaAvg[soda]));
		}
		System.out.println();
		
		for (int person = 0; person < PEOPLE; person++) {
			personAvg[person] = (float)personSum[person]/SODAS;
			
			System.out.println("Person #" + (person+1) + ": " +
					fmt.format(personAvg[person]));
		}
		
		// lets find the variances for each soda
		// Var[X] = E[(X - u_X)'2] = sum((X - u_X)^2) / (n-1)
		double[] sodaVars = new double[SODAS];
		
		for (int thisSoda = 0; thisSoda < SODAS; thisSoda++)
			for(int thisPerson = 0; thisPerson < PEOPLE; thisPerson++)
				
				sodaVars[thisSoda] += Math.pow((scores[thisSoda][thisPerson] -
						sodaAvg[thisSoda]), 2) / (PEOPLE - 1);
		
		fmt = new DecimalFormat("0.###");
		System.out.println();
		System.out.println("Variances: ");
		for (double k : sodaVars)
			System.out.println(fmt.format(k));
	}	
}