
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

}

class containsEChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.contains("e");
	}
}

class isLowerCasedChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.toLowerCase() == s;
	}

}
// Add your choosers here