import exception.AnotherException;
import exception.FailureException;
import exception.SomeException;


public class Origin {

	public void doSomething() {
		try {
			/* primary action */
		} catch (SomeException e) {
			try {
				/* alternate action */
			} catch (AnotherException e2) {
				throw new FailureException();
			}
		}
	}
}
