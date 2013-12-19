public class ExampleForNestedTryWithResourcesStatement {

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
