import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if (expected == null) {
			assertNull(s);
		} else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s : arr)
			result += "\n" + s;
		return (result + "\n");
	}

	/* Add your own Worklist tests below */

	/*
	 * ************** HINT ******************** Use the helper methods to create
	 * simple tests that are easier to debug.
	 */

	SearchWorklist swr = new StackWorklist();
	SearchWorklist qwr = new QueueWorklist();

	@Test
	public void StandardStackTest() {
		Maze m = new Maze(new String[] { "#___", "__F_", "S##_", "____" });
		String[] rs = new String[] { "#___", "__F*", "S##*", "****" };
		checkMaze(swr, m, rs);
	}

	@Test
	public void StandardQueueTester() {
		Maze m = new Maze(new String[] { "#___", "__F_", "S##_", "____" });
		String[] rq = new String[] { "#___", "**F_", "S##_", "____" };
		checkMaze(qwr, m, rq);
	}

	@Test
	public void StartAndEndNextToTesterQ() {
		Maze m = new Maze(new String[] { "#___", "_SF_", "_##_", "____" });
		String[] rq = new String[] { "#___", "_SF_", "_##_", "____" };

		checkMaze(qwr, m, rq);
	}

	@Test
	public void CornerLocationTesterS() {
		Maze m = new Maze(new String[] { "S___", "_##_", "__#_", "___F" });
		String[] rs = new String[] { "S***", "_##*", "__#*", "___F" };

		checkMaze(swr, m, rs);

	}

	@Test
	public void CornerLocationTesterQ() {
		Maze m = new Maze(new String[] { "S___", "_##_", "__#_", "___F" });

		String[] rq = new String[] { "S___", "*##_", "*_#_", "***F" };

		checkMaze(qwr, m, rq);
	}

	@Test
	public void NoWallsTesterQ() {
		Maze m = new Maze(new String[] { "____", "_S__", "____", "___F" });

		String[] rq = new String[] { "____", "_S__", "_*__", "_**F" };

		checkMaze(qwr, m, rq);
	}

	@Test
	public void LotsOfWallsTester() {
		Maze m = new Maze(new String[] { "#_#_", "____", "_##S", "F___" });
		String[] rq = new String[] { "#_#_", "____", "_##S", "F***" };
		checkMaze(qwr, m, rq);
	}

	// @Test
	public void dummyTest() {

		assertEquals("TODO: Remove this dummy test after writing your own tests.", "This is a dummy test.");
	}

}
