import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.FailureException;
import exception.SomeException;

public class SolutionFromChiaCheng {

	/*
	 * 首先，2008的26行的「attempt <= maxRetryTimes」是多餘的code，刪除不影響執行情況。
	 * 
	 * 另外，flag的改變可以放在try的最後，不需要進入try就改，然後才在catch改回來。
	 * 
	 * 並家政套用多型來讓語意清楚。
	 */
	
	public void doSomething() {
		boolean isRetry = true;
		
		List<Object> instances = getInstances();
		Iterator<Object> iterator = instances.iterator();
		
		while (isRetry) {
			// 此行可以放在catch內，特意放這邊是為了防止instances長度0的情況
			if (!iterator.hasNext()) {
				throw new FailureException();
			}
			
			Object instance = (Object) iterator.next();
			try {
				/* instance.action() */
				isRetry = false;
			} catch (SomeException e) {
			}
		}
	}
	
	public List<Object> getInstances() {
		return new ArrayList<Object>();
	}
}
