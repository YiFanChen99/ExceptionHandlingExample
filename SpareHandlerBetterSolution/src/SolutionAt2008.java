import exception.FailureException;
import exception.SomeException;

public class SolutionAt2008 {

	public void doSomething() {
		int maxRetryTimes = 2;
		int attempt = 0;
		boolean isRetry = false;
		
		do {
			try {
				isRetry = false;
				if(attempt == 0) {
					/* primary action */
				} else {
					/* alternate action */
				}
			} catch (SomeException e) {
				isRetry = true;
				attempt++;
				if (attempt > maxRetryTimes) {
					throw new FailureException();
				}
			}
		} while (attempt <= maxRetryTimes && isRetry);
	}
}
