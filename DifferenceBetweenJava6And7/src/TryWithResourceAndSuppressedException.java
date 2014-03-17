
import java.io.Closeable;
import java.io.IOException;

public class TryWithResourceAndSuppressedException {

	/*
	 * Try-with-resource
	 */

	public void tryWithResourcesStatementInJava7() {
		try (Resource resource1 = new Resource();
				Resource resource2 = new Resource();) {
			resource1.doSomething();
			resource2.doSomething();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void closingWithoutTryWithResourcesInJava6A() 
			throws IOException {
		Resource resource1 = new Resource();
		Resource resource2 = new Resource();
		try {
			resource1.doSomething();
			resource2.doSomething();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			resource2.close();
			resource1.close();
		}
	}
	
	public void closingWithoutTryWithResourcesInJava6B() {
		Resource resource1 = new Resource();
		Resource resource2 = new Resource();
		try {
			resource1.doSomething();
			resource2.doSomething();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			closeResource(resource2);
			closeResource(resource1);
		}
	}
	
	private void closeResource(Closeable resource) {
		try {
			resource.close();
		} catch (Exception e) {
			System.out.println("Logging: Exception when closing resource");
		}
	}

	/*
	 * Suppressed Exception
	 */
	
	public static void main(String[] args) {
		try {
			TryWithResourceAndSuppressedException eh = new TryWithResourceAndSuppressedException();
			eh.exceptionWhenClosingInFinallyInJava6();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void exceptionWhenClosingInFinallyInJava6() throws IOException {
		Resource resource1 = new Resource();
		try {
			resource1.doSomething();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			resource1.close();
		}
	}

	public void exceptionWhenClosingInFinallyInJava7() throws IOException {
		try (Resource resource1 = new Resource();) {
			resource1.doSomething();
		} catch (IOException e) {
//			Throwable[] suppressed = e.getSuppressed();
//			System.out.println("The exception been suppressed is: "
//					+ suppressed[0]);
			throw new RuntimeException(e);
		}
	}

	/*
	 * For reference 
	 */
	
	private class Resource implements Closeable {
		public Resource() {
		}
		public void doSomething() throws IOException {
			throw new IOException();
		}
		@Override
		public void close() throws IOException {
			throw new IOException();
		}
	}
	
}
