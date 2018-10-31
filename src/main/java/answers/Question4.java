package answers;

import static java.lang.Integer.parseInt;

public class Question4 {

	public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
		int globalMin = Integer.MAX_VALUE;
 		for (int i=0; i<rows.length;i++){
			int localMin = 0, machines = 0;
			for(int j=0;j<=rows[i].length;j++){
				if (machines == numberMachines) globalMin = Math.min(globalMin, localMin);

				if (rows[i][j].equals ('X')) {
					localMin = 0;
					machines = 0;
				}
				else {
					if(machines == numberMachines) {
						globalMin = Math.min(globalMin, localMin);
						localMin = localMin - parseInt (rows[i][j-numberMachines]) + parseInt (rows[i][j]);
					}
					else {
						localMin += parseInt(rows[i][j]);
						machines ++;
					}
				}
			}
			if (machines == numberMachines) globalMin = Math.min(globalMin, localMin);
		}
		return globalMin;
	}

}
