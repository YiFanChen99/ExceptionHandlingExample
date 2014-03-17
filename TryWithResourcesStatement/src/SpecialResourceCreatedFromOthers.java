import java.io.IOException;

public class SpecialResourceCreatedFromOthers {

	public static void main(String[] args) {
		createResourcesByFactory();
	}

	/*
	 * Automatically closing resource2 will not throw an exception.
	 * And the NullPointerException from closing resource1 been thrown.
	 * So "maybe" the automatically closing will check if resource is null or not.
	 */
	public static void createResourcesByFactory() {
		SpecialResourceCreatedFromOthers factory = new SpecialResourceCreatedFromOthers();
		try (Resource resource1 = factory.getNewResource();
				Resource resource2 = factory.getNullResource();) {
			throw new IllegalArgumentException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class Resource implements AutoCloseable {
		public void doSomething() throws IOException {
			throw new IOException();
		}
		@Override
		public void close() throws Exception {
			throw new NullPointerException();
		}
	}

	private Resource getNullResource() {
		return null;
	}
	private Resource getNewResource() {
		return new Resource();
	}
}
