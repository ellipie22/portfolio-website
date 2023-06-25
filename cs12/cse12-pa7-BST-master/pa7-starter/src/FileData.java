/**
 * File header Author: Pierre Ellie This is the FileData.java file, this file is
 * used for defining what FileData is FileData is used in the FileSystem file
 * for storing information, speicfically name, directory and last date modified
 */

public class FileData {

	public String name;
	public String dir;
	public String lastModifiedDate;

	// TODO
	public FileData(String name, String directory, String modifiedDate) {
		this.name = name;
		this.dir = directory;
		this.lastModifiedDate = modifiedDate;
	}

	// TODO
	@Override
	public String toString() {
		String result = "{Name: " + this.name + ", Directory: " + this.dir + ", Modified Date: " + this.lastModifiedDate
				+ "}";

		return result;

	}
}