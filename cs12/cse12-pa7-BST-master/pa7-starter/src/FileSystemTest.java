
/**
 * File header
 * Author: Pierre Ellie
 * This is the FileSystemTest.java file, Simply used for testing if the FileSystem works.
 * */
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FileSystemTest {
	@Test
	public void testAdd() {

		FileSystem f = new FileSystem("input.txt");
		// f.add("mySample.txt", "/root", "2021/03/02");

		List<String> expected = new ArrayList<String>();
		String s1 = "2021/02/06: {Name: mySample2.txt, Directory: /user, Modified Date: 2021/02/06}";
		String s2 = "2021/02/01: {Name: mySample1.txt, Directory: /root, Modified Date: 2021/02/01}";
		String s3 = "2021/02/01: {Name: mySample.txt, Directory: /home, Modified Date: 2021/02/01}";
		// String s4 = "2021/03/02: {Name: mySample.txt, Directory: /root, Modified
		// Date: 2021/03/02}";

		expected.add(s1);
		expected.add(s2);
		expected.add(s3);

		assertEquals(expected, f.outputDateTree());

	}

	@Test
	public void testFilter() {

		FileSystem f = new FileSystem("input.txt");

		List<String> expected = new ArrayList<String>();

		String s2 = "2021/02/01: {Name: mySample1.txt, Directory: /root, Modified Date: 2021/02/01}";

		expected.add(s2);

		assertEquals(expected, f.filter("mySample1").outputDateTree());

	}
}