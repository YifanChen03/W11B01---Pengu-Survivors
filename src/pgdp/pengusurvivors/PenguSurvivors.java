package pgdp.pengusurvivors;

import java.util.Arrays;

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
		FlowGraph output1 = new FlowGraph();
		FlowGraph output2 = new FlowGraph();
		int[] workaholicsFriendsNumber = new int[workaholics.length];
		int[] procrastinatorsFriendsNumber = new int[procrastinators.length];
		//fill with zeros
		for (int i = 0; i < workaholics.length; i++) {
			workaholicsFriendsNumber[i] = 0;
		}
		for (int i = 0; i < procrastinators.length; i++) {
			procrastinatorsFriendsNumber[i] = 0;
		}
		//add if they are in friendship
		for (int[] fs : friendships) {
			int workaholicID = fs[0];
			int procrastinatorID = fs[1];
			workaholicsFriendsNumber[workaholicID]++;
			procrastinatorsFriendsNumber[procrastinatorID]++;
		}

		int workaholicWithMostFriends =
				Arrays.stream(workaholics).reduce((w1, w2) ->
						workaholicsFriendsNumber[w1] > workaholicsFriendsNumber[w2] ? w1 : w2).orElse(0);
		int procrastinatorWithMostFriends =
				Arrays.stream(procrastinators).reduce((n1, n2)
						-> procrastinatorsFriendsNumber[n1] > procrastinatorsFriendsNumber[n2] ? n1 : n2).orElse(0);

		FlowGraph.Vertex first = new FlowGraph.Vertex(String.valueOf(workaholics[workaholicWithMostFriends]));

		output1.getVertices().add(first);
		output1.setSource(first);

		return output1;
	}

}
