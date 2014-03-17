public class ExampleForNestedTryWithResourcesStatement {

	/*
	 * An example to show the people in c# will code like this
	 */
	public void nestedTryWhenUsingConnection() throws Exception {
		try (Connection connection = new Connection()) {
			connection.doSomeSetUp();
			try (Transaction transaction = connection.openTransaction()) {
				connection.doSomething();
				transaction.commit();
			}
		}
	}
	
	/*
	 * For reference 
	 */
	
	class Connection implements AutoCloseable {
		public void doSomeSetUp() {
		}
		public Transaction openTransaction() {
			return new Transaction();
		}
		public void doSomething() {
		}
		@Override
		public void close() throws Exception {
		}
	}

	class Transaction implements AutoCloseable {
		public void commit() {
		}
		@Override
		public void close() throws Exception {
		}
	}
}
