import java.io.Closeable;


/**
 * There are same semantics with different syntax.
 * Whether we want to say that they are both careless cleanup or not?
 * If, it means the reviewer/tool have to care about the right-hand-side of assingment.
 * If not, is same semantics have different judgment make sense?
 * 
 * 目前我們認為 Perfect reviewer 應該能認出此兩種寫法皆為同一語意的壞味道。
 * 而若 Robusta 無法偵測出此種壞味道，則接受為軟體限制。
 * 
 * 未被採用的觀點：
 * 「如果單純拿回傳物件來關，代表此方法有關閉該資源的責任，
 * 　而若先指派了其參考，則代表該物件有其他用途，
 * 　也就是說這個方法同時負擔了一個以上的責任（包含使用該資源與關閉該資源），
 * 　因為該壞味道造成CC的誤判算是合理。」
 * 
 * This is just a example, And both field variable and parameter have the same issue.
 */
public class SameMeaningWithDiffCode {
	
	public void closeResourceFromMethodWithReturned() throws Exception {
		doSomething();
		getResource().close();
	}

	/*
	 * Example in ant (3):
	 * 	org.apache.tools.ant.taskdefs.optional.sound.AntSoundPlayer L179
	 * 	org.apache.tools.ant.util.FileUtils L1534
	 * 	org.apache.tools.ant.taskdefs.Pack L183
	 */
	public void closeResourceFromMethodWithReference() throws Exception {
		doSomething();
		Closeable resource = getResource();
		resource.close();
	}
	
	public Closeable getResource() {
		return null;
	}
	public void doSomething() throws Exception {
	}
}
