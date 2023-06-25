package cse12pa4student;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Measurement> resultsList = Measure.measure(new String[] { "A", "B", "C", "D", "E", "F" }, 40, 51);
		System.out.println(Measure.measurementsToCSV(resultsList));
		System.out.println("done");

	}
}
