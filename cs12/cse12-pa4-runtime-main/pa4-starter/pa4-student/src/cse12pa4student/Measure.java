package cse12pa4student;

import static cse12pa4mysteries.Mysteries.mysteryA;
import static cse12pa4mysteries.Mysteries.mysteryB;
import static cse12pa4mysteries.Mysteries.mysteryC;
import static cse12pa4mysteries.Mysteries.mysteryD;
import static cse12pa4mysteries.Mysteries.mysteryE;
import static cse12pa4mysteries.Mysteries.mysteryF;

import java.util.ArrayList;
import java.util.List;

public class Measure {

	public static List<Measurement> measure(String[] toRun, int startN, int stopN) {
		/** TODO **/
		List<Measurement> resultsList = new ArrayList<Measurement>();
		for (int i = 0; toRun.length > i; i++) {
			String curr = toRun[i];
			for (int j = startN; j < stopN + 1; j++) {

				if (curr == "A") {
					long startTime = System.nanoTime();
					mysteryA(j);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement runResult = new Measurement(curr, j, estimatedTime);
					resultsList.add(runResult);
				}
				if (curr == "B") {
					long startTime = System.nanoTime();
					mysteryB(j);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement runResult = new Measurement(curr, j, estimatedTime);
					resultsList.add(runResult);
				}
				if (curr == "C") {
					long startTime = System.nanoTime();
					mysteryC(j);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement runResult = new Measurement(curr, j, estimatedTime);
					resultsList.add(runResult);
				}
				if (curr == "D") {
					long startTime = System.nanoTime();
					mysteryD(j);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement runResult = new Measurement(curr, j, estimatedTime);
					resultsList.add(runResult);
				}
				if (curr == "E") {
					long startTime = System.nanoTime();
					mysteryE(j);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement runResult = new Measurement(curr, j, estimatedTime);
					resultsList.add(runResult);
				}
				if (curr == "F") {
					long startTime = System.nanoTime();
					mysteryF(j);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement runResult = new Measurement(curr, j, estimatedTime);

					resultsList.add(runResult);
				}
			}
		}
		// Example call to mystery method

		return resultsList;
	}

	public static String measurementsToCSV(List<Measurement> toConvert) {
		/** TODO **/

		String results = "name,n,nanoseconds\n";
		for (int i = 0; toConvert.size() > i; i++) {
			results = results + toConvert.get(i).name + " " + toConvert.get(i).valueOfN + " "
					+ toConvert.get(i).nanosecondsToRun + "\n";
		}

		return results;

	}

	/* Add any helper methods you find useful */

}
