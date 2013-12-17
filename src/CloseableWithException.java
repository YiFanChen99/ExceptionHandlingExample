import java.io.Closeable;
import java.io.IOException;

public class CloseableWithException implements Closeable {

	private String name = "";

	public CloseableWithException(String name) {
		this.name = name;
		System.out.println("Created " + name);
	}

	public void doSomething() throws IOException {
		System.out.println("Do something by " + name);
		throw new IOException(name);
	}

	@Override
	public void close() throws IOException {
		System.out.println("Close " + name);
		throw new IOException(name);
	}

}
