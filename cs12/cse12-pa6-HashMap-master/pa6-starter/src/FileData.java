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
		String results = "{Name: " + name + ", Directory: " + dir + ", Modified Date: " + lastModifiedDate + "}";
		return results;

	}
}
