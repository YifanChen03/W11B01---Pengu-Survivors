package pgdp.pengusurvivors;

public class PenguSurvivors {

	protected PenguSurvivors() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns a model for the matching of workaholics to procrastinators.
	 * 
	 * @param workaholics     array of names/ids of workaholic penguins
	 * @param procrastinators array of names/ids of procrastinating penguins.
	 * @param friendships     relationship between the two groups (each array
	 *                        contains the index of the corresponding workaholic
	 *                        penguin (friendships[i][0]) and the index of the
	 *                        corresponding procrastinating penguin
	 *                        (friendships[i][1]))
	 * @return model for the matching of workaholics to procrastinators
	 */
	public static FlowGraph generateModel(int[] workaholics, int[] procrastinators, int[][] friendships) {
		// TODO
		return null;
	}

}
