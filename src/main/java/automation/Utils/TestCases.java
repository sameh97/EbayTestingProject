package automation.Utils;

public enum TestCases {
	T1("Testing shopping as guest");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return this.testName;
	}
}
