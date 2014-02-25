import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;

public class IssueExample {

	/*
	 * There is no exception during assignment and close,
	 * but there are some exceptions during declared and close.
	 * So it is an False Positive example
	 */
    public void close() throws Exception {
        FileInputStream fis = null;
        
        doSomething();
        doSomething();
        
        try {
        	fis = new FileInputStream("");
		} catch (Exception e) {
		} finally {
			fis.close();
		}
    }
    
    /*
     * For the concrete closeable below
     */
	class SuperCloseable implements Closeable {
		public void close() throws IOException {
		}
		public void doSomething() throws IOException {
			throw new IOException();
		}
	}

	/**
	 * This close statement will not be detected.
	 * (SuperMethodInvocation is not a MethodInvocation)
	 * 
	 * Example in ant: org.apache.tools.ant.taskdefs.optional.perforce.P4OutputStream(super.close)
	 * There are more
	 */
	class ConcreteCloseable extends SuperCloseable {
		public void close() throws IOException {
			doSomething();
			super.close();
		}
	}
    
	public void doSomething() throws Exception {
		throw new Exception();
	}
}
