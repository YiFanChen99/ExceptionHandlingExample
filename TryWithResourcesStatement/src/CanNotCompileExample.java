import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CanNotCompileExample {

	/**
	 * Don't try to close resource in finally block
	 */
	public static void tryWithResourcesCanNotBeRecognizeInFinally() {
		try (CloseableWithException resource = new CloseableWithException(
				"resource")) {
			resource.doSomething();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			resource.close();
		}
	}

	/**
	 * Expression of try should be VariableDeclarationExpression
	 */
	public static void declaredResourceBeforeTryStatement() {
		CloseableWithException resource = null;
		try (resource = new CloseableWithException(
				"resource")) {
			resource.doSomething();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			resource.close();
		}
	}
}
