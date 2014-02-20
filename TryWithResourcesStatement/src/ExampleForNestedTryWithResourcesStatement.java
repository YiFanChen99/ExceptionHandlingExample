public class ExampleForNestedTryWithResourcesStatement {

	/*
	 * Can't compile, just an example to show the people in c# will code like this
	 */
	public static void nestedTryWhenUsingConnection() {
		try (Connection connection = new Connection()) {
			connection.doSomeSetUp();
			try (Transaction transaction = connection.openTransaction()) {
				connection.doSomething();
				transaction.commit();
			}
		}
	}
}
