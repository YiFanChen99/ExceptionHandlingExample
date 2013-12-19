import java.io.IOException;

public class Example {

	public static void main(String[] args) {
		tryWithResourcesStatementWithTwoResources();
	}

	public static void formOfCreateResourceInJava6WithoutClose() {
		CloseableWithException resource = null;
		try {
			resource = new CloseableWithException("resource");
			resource.doSomething();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Never closed.
	 */
	public static void createResourceInJava6WithoutClose() {
		CloseableWithException resource = null;
		try {
			System.out.println("Entered try block");
			resource = new CloseableWithException("resource");
			resource.doSomething();
		} catch (IOException e) {
			System.out.println("Entered catch block");
			System.out.println("Threw Exception in catch block");
			throw new RuntimeException(e);
		}
	}

	public static void formOfCreateResourceInJava6WithCloseInFinally() {
		CloseableWithException resource = null;
		try {
			resource = new CloseableWithException("resource");
			resource.doSomething();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				resource.close();
			} catch (IOException e2) {
				throw new RuntimeException(e2);
			}
		}
	}

	/**
	 * The exception thrown from catch will be overwritten, we can get the
	 * exception from finally block only.
	 */
	public static void createResourceInJava6WithCloseInFinally() {
		CloseableWithException resource = null;
		try {
			System.out.println("Entered try block");
			resource = new CloseableWithException("resource");
			resource.doSomething();
		} catch (IOException e) {
			System.out.println("Entered catch block");
			System.out.println("Threw Exception in catch block");
			throw new RuntimeException(e);
		} finally {
			System.out.println("Entered finally block");
			try {
				resource.close();
			} catch (IOException e2) {
				System.out.println("Threw Exception in finally block");
				throw new RuntimeException(e2);
			}
		}
	}

	public static void formOfTryWithResourcesStatementInJava7() {
		try (CloseableWithException resource = new CloseableWithException(
				"resource")) {
			resource.doSomething();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Resource will be closed before enter the catch block
	 */
	public static void tryWithResourcesStatementInJava7() {
		System.out.println("Before try statement");
		try (CloseableWithException resource = new CloseableWithException(
				"resource")) {
			System.out.println("Entered try block");
			resource.doSomething();
		} catch (IOException e) {
			System.out.println("Entered catch block");
			System.out.println("Threw Exception in catch block");
			throw new RuntimeException(e);
		}
	}

	public static void formOfTryWithResourcesStatementWithoutCatchAndFinallyBlock()
			throws IOException {
		try (CloseableWithException resource = new CloseableWithException(
				"resource")) {
			resource.doSomething();
		}
	}

	public static void formOfTryWithResourcesStatementWithTwoResources() {
		try (CloseableWithException fisrtResource = new CloseableWithException(
				"fisrt resource");
				CloseableWithException secondResource = new CloseableWithException(
						"second resource")) {
			fisrtResource.doSomething();
			secondResource.doSomething();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * The resource create later will be closed automatically earlier. And even
	 * if there is an exception when closing the resources, it will try to close
	 * all resources.
	 */
	public static void tryWithResourcesStatementWithTwoResources() {
		System.out.println("Before try statement");
		try (CloseableWithException fisrtResource = new CloseableWithException(
				"fisrt resource");
				CloseableWithException secondResource = new CloseableWithException(
						"second resource")) {
			System.out.println("Entered try block");
			fisrtResource.doSomething();
			secondResource.doSomething();
		} catch (IOException e) {
			System.out.println("Entered catch block");
			System.out.println("Threw Exception in catch block");
			throw new RuntimeException(e);
		}
	}
	
}
