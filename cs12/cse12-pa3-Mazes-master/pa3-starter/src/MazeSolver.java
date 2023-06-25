/* Class to implement a Maze solver */

public abstract class MazeSolver {

	public static Square solve(Maze maze, SearchWorklist wl) {
		/* Complete this method */
		Square curr = maze.start;
		wl.add(curr);
		curr.visit();

		int row = curr.getRow();
		int col = curr.getCol();
		System.out.println(maze.contents[row][col]);
		while (wl.isEmpty() != true) {

			curr = wl.remove();

			row = curr.getRow();
			col = curr.getCol();
			curr.visit();

			System.out.println("we are currently at :" + curr);
			System.out.println("prev is :" + curr.getPrevious());
			if (curr == maze.finish) {
				System.out.println("Found end");
				return curr;
			} else {

				Square check;
				for (int i = -1; i < 2; i += 2) {

					if (availableNeighbor(maze, curr, i, 0) == true) {
						check = maze.contents[row + i][col];
						if (check.getIsWall() != true && check.isVisited() != true) {
							// System.out.println("added " + check);
							if (check.getPrevious() == null || check.getPrevious() != curr.getPrevious()) {
								Square previous = curr;
								check.setPrevious(previous);
							}

							System.out.println("added :" + check + " with prev: " + check.getPrevious());
							wl.add(check);
						}
					}
				}

				for (int i = 1; i > -2; i -= 2) {
					// System.out.println(availableNeighbor(maze, curr, 0, i));
					if (availableNeighbor(maze, curr, 0, i) == true) {
						check = maze.contents[row][col + i];
						if (check.getIsWall() != true && check.isVisited() != true) {
							// System.out.println("added " + check);
							if (check.getPrevious() == null || check.getPrevious() != curr.getPrevious()) {
								Square previous = curr;
								check.setPrevious(previous);
							}

							System.out.println("added :" + check + " with prev: " + check.getPrevious());
							wl.add(check);
						}
					}
				}

				// System.out.println("Wl is " + wl.isEmpty());
			}

		}
		System.out.println("failed find");
		return null;
	}

	/* Add any helper methods you want */
	public static boolean availableNeighbor(Maze maze, Square s, int rowOffset, int colOffset) {
		int limitR = maze.rows;
		int limitC = maze.cols;
		if ((s.getCol() + colOffset) < 0 || (s.getCol() + colOffset) >= limitC) {
			return false;
		}
		if ((s.getRow() + rowOffset) >= limitR || (s.getRow() + rowOffset) < 0) {
			return false;
		}

		return true;
	}
}
