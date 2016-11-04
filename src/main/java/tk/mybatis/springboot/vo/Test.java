package tk.mybatis.springboot.vo;

public class Test {
	private String testAbc;

	public String getTestAbc() {
		return testAbc;
	}

	public void setTestAbc(String testAbc) {
		this.testAbc = testAbc;
	}

	@Override
	public String toString() {
		return "Test [testAbc=" + testAbc + "]";
	}

}
