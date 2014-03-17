import java.io.IOException;
import java.sql.SQLException;

public class SmarterRethrowAndMultiCatch {

	/*
	 * Smarter Rethrow
	 */

	public static void main(String[] args) {
		try {
			SmarterRethrowAndMultiCatch eh = new SmarterRethrowAndMultiCatch();
			eh.rethrowByDeclaredSubclass();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void preciseRethrowInJava6() 
			throws IOException, SQLException {
		try {
			throwMultiExceptions(true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	/*
	 * Caller have to handle "Exception" type
	 */
	public void rethrowByChangingInterface()
			throws Exception {
		try {
			throwMultiExceptions(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	public void rethrowByDeclaredSubclass()
			throws IOException, SQLException {
		try {
			throwMultiExceptions(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	/*
	 * Multi-Catch
	 */

	public void rethrowByMultiCatchType()
			throws IOException, SQLException {
		try {
			throwMultiExceptions(true);
        } catch (IOException | SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	/*
	 * For reference
	 */

	private void throwMultiExceptions(boolean condition) throws IOException,
			SQLException {
		if (condition) {
			throw new IOException();
		} else {
			throw new SQLException();
		}
	}
}
