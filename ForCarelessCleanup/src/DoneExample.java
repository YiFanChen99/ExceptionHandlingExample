import java.io.InputStream;

import reference.ClassWithGetResource;

public class DoneExample {

	/*
	 * It can be detected now: Close itself
	 */
	public void closeResourceByInvokeMyClose() throws Exception {
		doSomething();
		close(); // Unsafe
	}
	
	/*
	 * It can be detected now: Closing the resource return by a method
	 */
	public void closeResourceByInvokeMyClose1() throws Exception {
		ClassWithGetResource resourceManager = new ClassWithGetResource();
		resourceManager.getResource().close(); // Unsafe
	}

	/*
	 * It will not be detected now: Closing resource by closer
	 * Now we can get the correct beginning position
	 */
	public void closeByUserDefinedMethod() throws Exception {
		doSomething();

		InputStream is = null;
		try {
			int returnValue = is.read();
		} finally {
			closeResource(is); // Safe even user defined
		}
	}

	public void closeResource(InputStream closeable) {
	}

	public void doSomething() throws Exception {
		throw new Exception();
	}
	
	public void close() {
	}
}
