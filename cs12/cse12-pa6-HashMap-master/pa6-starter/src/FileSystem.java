import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileSystem {

	MyHashMap<String, ArrayList<FileData>> nameMap;
	MyHashMap<String, ArrayList<FileData>> dateMap;

	// TODO
	public FileSystem() {

		this.dateMap = new MyHashMap<String, ArrayList<FileData>>();
		this.nameMap = new MyHashMap<String, ArrayList<FileData>>();
	}

	// TODO
	public FileSystem(String inputFile) {
		// Add your code here
		FileSystem newSystem = new FileSystem();
		// newSystem.nameMap = nameMap;
		// newSystem.dateMap = dateMap;

		try {
			File f = new File(inputFile);
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String[] data = sc.nextLine().split(", ");
				// Add your code here
				for (int i = 0; i < data.length; i = i + 3) {
					FileData newData = new FileData(data[i], data[i + 1], data[i + 2]);
					newSystem.add(newData.name, newData.dir, newData.lastModifiedDate);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

	// TODO
	public boolean add(String fileName, String directory, String modifiedDate) {
		ArrayList<FileData> Data = new ArrayList<FileData>();
		FileData DataPoint = new FileData(fileName, directory, modifiedDate);
		Data.add(DataPoint);
		nameMap.put(fileName, Data);
		dateMap.put(modifiedDate, Data);

		return true;

	}

	// TODO
	public FileData findFile(String name, String directory) {
		ArrayList<FileData> Data = nameMap.get(name);
		for (int i = 0; i < Data.size(); i++) {
			if (Data.get(i).name == name) {
				return Data.get(i);
			}
		}

		return null;

	}

	// TODO
	public ArrayList<String> findAllFilesName() {
		ArrayList<String> results = new ArrayList<String>();

		for (int i = 0; i < nameMap.size(); i++) {
			String key = nameMap.keys().get(i);
			FileData result = nameMap.get(key).get(i);
			results.add(result.name);
		}
		return results;

	}

	// TODO
	public ArrayList<FileData> findFilesByName(String name) {
		ArrayList<FileData> results = new ArrayList<FileData>();

		for (int i = 0; i < nameMap.size(); i++) {
			String key = nameMap.keys().get(i);
			FileData result = nameMap.get(key).get(i);
			results.add(result);
		}
		return results;

	}

	// TODO
	public ArrayList<FileData> findFilesByDate(String modifiedDate) {
		ArrayList<FileData> results = new ArrayList<FileData>();

		for (int i = 0; i < dateMap.size(); i++) {
			String key = dateMap.keys().get(i);
			FileData result = dateMap.get(key).get(i);
			results.add(result);
		}
		return results;

	}

	// TODO
	public ArrayList<FileData> findFilesInMultDir(String modifiedDate) {
		ArrayList<FileData> results = new ArrayList<FileData>();

		for (int i = 0; i < nameMap.size(); i++) {
			String key = nameMap.keys().get(i);
			FileData result = nameMap.get(key).get(i);
			results.add(result);
		}
		return results;

	}

	// TODO
	public boolean removeByName(String name) {
		boolean result = false;
		for (int i = 0; i < nameMap.size(); i++) {

			String key = nameMap.keys().get(i);
			if (nameMap.get(key).get(i).name == name) {
				nameMap.remove(key);
				result = true;
			}

		}
		return result;

	}

	// TODO
	public boolean removeFile(String name, String directory) {
		boolean result = false;
		for (int i = 0; i < nameMap.size(); i++) {

			String key = nameMap.keys().get(i);
			if (nameMap.get(key).get(i).name == name) {
				nameMap.remove(key);
				result = true;
			}

		}
		return result;

	}

}
