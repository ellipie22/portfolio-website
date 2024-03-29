
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS = Arrays.asList(new Object[][] { { "Linked" }, { "Array" } });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

	// Don't change code above this line, it ensures the autograder works as
	// expected

	// This is a sample test; you can keep it, change it, or remove it as you like.
	// Note that it uses the method `assertArrayEquals`, which you should use to
	// test equality of arrays in this PA.
	// @Test
	public void testSimpleToArray() {
		// Using the generic list to create an Integer list
		Integer[] test_input = { 1, 2, 3 };
		MyList<Integer> int_s = makeList(test_input);
		assertArrayEquals(test_input, int_s.toArray());

		// Using the generic list to create a String list
		String[] string_input = { "a", "b", "c" };
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}

	// @Test
	public void testSimpleToArrayEmpty() {
		Integer[] test_input = {};
		MyList<Integer> string_s = makeList(test_input);

		assertArrayEquals(test_input, string_s.toArray());
	}

	// @Test
	public void testSimpleToArrayLarge() {
		Integer[] test_input = { 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1 };
		MyList<Integer> test_s = makeList(test_input);

		assertArrayEquals(test_input, test_s.toArray());
	}

	// @Test
	public void testSimpleEmptyOne() {
		Integer[] test_input = { 1 };
		MyList<Integer> int_s = makeList(test_input);

		assertEquals(false, int_s.isEmpty());
	}

	// @Test
	public void testSimpleEmptyMulti() {
		Integer[] test_input = { 1, 2, 3 };
		MyList<Integer> int_s = makeList(test_input);

		assertEquals(false, int_s.isEmpty());
	}

	// @Test
	public void testSimpleEmptyNone() {
		Integer[] test_input = {};
		MyList<Integer> int_s = makeList(test_input);

		assertEquals(true, int_s.isEmpty());
	}

	// @Test
	public void testSimpleTransform() {

		// Using the generic list to create a String list
		String[] string_input = { "a", "b", null, "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", };
		String[] string_output = { "A", "B", null, "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", };
		MyList<String> string_s = makeList(string_input);
		string_s.transformAll(new UpperCaseTransformer());
		assertArrayEquals(string_output, string_s.toArray());
	}

	// @Test
	public void testSimpleTransform2Items() {

		// Using the generic list to create a String list
		String[] string_input = { "a", "b" };
		String[] string_output = { "A", "B" };
		MyList<String> string_s = makeList(string_input);
		string_s.transformAll(new UpperCaseTransformer());
		assertArrayEquals(string_output, string_s.toArray());
	}

	// @Test
	public void testSimpleTransformEmpty() {

		// Using the generic list to create a String list
		String[] string_input = {};
		String[] string_output = {};
		MyList<String> string_s = makeList(string_input);
		string_s.transformAll(new UpperCaseTransformer());
		assertArrayEquals(string_output, string_s.toArray());
	}

	@Test
	public void testSimpleChoose() {

		// Using the generic list to create a String list
		String[] contents = { "longword", "two", "longer" };
		String[] contentsResults = { "longword", "longer" };
		MyList<String> agl = makeList(contents);
		agl.chooseAll(new LongWordChooser());
		assertArrayEquals(contentsResults, agl.toArray());
	}

	@Test
	public void testSimpleChooseEmpty() {

		// Using the generic list to create a String list
		String[] contents = {};
		String[] contentsResults = {};
		MyList<String> agl = makeList(contents);
		agl.chooseAll(new LongWordChooser());
		assertArrayEquals(contentsResults, agl.toArray());
	}

	@Test
	public void testSimpleChooseFirst() {

		String[] contents = { "two", "longer", "one" };
		String[] contentsResults = { "longer" };
		MyList<String> agl = makeList(contents);
		agl.chooseAll(new LongWordChooser());
		assertArrayEquals(contentsResults, agl.toArray());
	}

	@Test
	public void testAlternate1() {

		String[] contents = { "two", "longer", "one" };
		String[] contentsResults = { "longer", "one" };
		MyList<String> agl = makeList(contents);
		agl.chooseAll(new containsEChooser());
		assertArrayEquals(contentsResults, agl.toArray());
	}

	@Test
	public void testAlternate2() {

		String[] contents = { "two", "longer", "LONGER" };
		String[] contentsResults = { "two", "longer" };
		MyList<String> agl = makeList(contents);
		agl.chooseAll(new isLowerCasedChooser());
		assertArrayEquals(contentsResults, agl.toArray());
	}
}