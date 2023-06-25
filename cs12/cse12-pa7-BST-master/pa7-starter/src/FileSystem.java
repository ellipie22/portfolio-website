
/**
 * File header
 * Author: Pierre Ellie
 * This is the FileSystem.java file, this is used to be able to store FileData
 * We can add, filter and output the System information
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSystem {

	BST<String, FileData> nameTree;
	BST<String, ArrayList<FileData>> dateTree;

	public FileSystem() {
		nameTree = new BST<String, FileData>();
		dateTree = new BST<String, ArrayList<FileData>>();
	}

	public FileSystem(String inputFile) {
		// Add your code here
		nameTree = new BST<String, FileData>();
		dateTree = new BST<String, ArrayList<FileData>>();
		try {
			File f = new File(inputFile);
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String[] data = sc.nextLine().split(", ");
				// Add your code here
				add(data[0], data[1], data[2]);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);

		}
	}

	public void add(String name, String dir, String date) {
		if (name != null && dir != null && date != null) {
			FileData toAdd = new FileData(name, dir, date);

			if (nameTree.containsKey(name)) {
				if (nameTree.get(name).lastModifiedDate.compareTo(toAdd.lastModifiedDate) < 0) {
					nameTree.replace(name, toAdd);

					if (dateTree.containsKey(date)) {
						dateTree.get(date).add(toAdd);
					} else {
						ArrayList<FileData> toAddList = new ArrayList<FileData>();
						toAddList.add(toAdd);
						dateTree.put(date, toAddList);
					}

				}
			} else {
				nameTree.put(name, toAdd);
				if (dateTree.containsKey(date)) {
					dateTree.get(date).add(toAdd);
				} else {
					ArrayList<FileData> toAddList = new ArrayList<FileData>();
					toAddList.add(toAdd);
					dateTree.put(date, toAddList);
				}
			}

		}

	}

	public ArrayList<String> findFileNamesByDate(String date) {
		if (date != null) {
			ArrayList<FileData> dateResults = dateTree.get(date);
			ArrayList<String> results = new ArrayList<String>();
			for (int i = 0; i < dateResults.size(); i++) {
				results.add(dateResults.get(i).name);
			}
			return results;
		} else {
			return null;
		}

	}

	public FileSystem filter(String startDate, String endDate) {
		FileSystem newSystem = new FileSystem();

		List<String> usedDates = dateTree.keys();

		for (int i = 0; i < usedDates.size() - 1; i++) {
			if (startDate.compareTo(usedDates.get(i)) <= 0 && endDate.compareTo(usedDates.get(i)) > 0) {

				ArrayList<FileData> findDate = dateTree.get(usedDates.get(i));

				for (int j = 0; j < findDate.size(); j++) {

					newSystem.add(findDate.get(j).name, findDate.get(j).dir, findDate.get(j).lastModifiedDate);
				}

			}
		}

		return newSystem;

	}

	public FileSystem filter(String wildCard) {
		FileSystem newSystem = new FileSystem();

		List<String> usedNames = nameTree.keys();

		for (int i = 0; i < usedNames.size(); i++) {
			if (usedNames.get(i).contains(wildCard)) {

				FileData toAdd = nameTree.get(usedNames.get(i));
				newSystem.add(toAdd.name, toAdd.dir, toAdd.lastModifiedDate);

			}
		}

		return newSystem;

	}

	public List<String> outputNameTree() {

		List<String> result = new ArrayList<String>();
		List<String> names = nameTree.keys();
		for (int i = 0; i < names.size(); i++) {
			result.add(names.get(i) + ": " + nameTree.get(names.get(i)).toString());
		}
		return result;

	}

	public List<String> outputDateTree() {

		List<String> result = new ArrayList<String>();
		List<String> dates = dateTree.keys();

		for (int i = 0; i < dates.size(); i++) {

			for (int j = 0; j < dateTree.get(dates.get(i)).size(); j++) {
				result.add(0, dateTree.get(dates.get(i)).get(j).lastModifiedDate + ": "
						+ dateTree.get(dates.get(i)).get(j).toString());

			}
		}

		return result;

	}

}
