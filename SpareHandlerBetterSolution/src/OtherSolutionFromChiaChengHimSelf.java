import java.util.ArrayList;
import java.util.List;

public class OtherSolutionFromChiaChengHimSelf {
	
	/*
	 * try中有break或flag之類的東西他覺得都怪怪的 所以打了這個版本嘗試
	 * 主要是try中只要專心做目標做happy scenario就好了，其他的東西不要管 
	 * 
	 * 我看完的第一個想法是：可以不要用遞迴ㄇ？
	 */
	
	public static void main(String[] args) {
		List<Subscriber> subscribers = new ArrayList<Subscriber>();
		subscribers.add(new InternetExplorer11());
		subscribers.add(new InternetExplorer10());
		subscribers.add(new InternetExplorer9());
		subscribers.add(new InternetExplorer8());
		subscribers.add(new InternetExplorer7());
		subscribers.add(new InternetExplorer6());
		subscribers.add(new InternetExplorer5());
		subscribers.add(new InternetExplorer4());
		subscribers.add(new InternetExplorer3());
		subscribers.add(new InternetExplorer2());
		subscribers.add(new InternetExplorer1());
		subscribers.add(new Chrome());
		我要買紅米機(subscribers);
	}

	public static void 我要買紅米機(List<Subscriber> subscribers) {
		if (subscribers.isEmpty())
			throw new RuntimeException("這種要求我這輩子沒見過");
		try {
			subscribers.get(0).搶紅米機();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			我要買紅米機(subscribers.subList(1, subscribers.size()));
		}
	}
}

interface Subscriber {
	void 搶紅米機();
}

class InternetExplorer11 implements Subscriber {

	@Override
	public void 搶紅米機() {
		throw new RuntimeException("糟了，是世界奇觀！");
	}
}

class InternetExplorer10 implements Subscriber {

	@Override
	public void 搶紅米機() {
		throw new RuntimeException("保安！可以讓人這樣搶了又搶 搶了又搶嗎？");
	}
}

class InternetExplorer9 implements Subscriber {
	@Override
	public void 搶紅米機() {
		throw new RuntimeException("你說了算");
	}
}

class InternetExplorer8 implements Subscriber {

	@Override
	public void 搶紅米機() {
		throw new RuntimeException("阿不就好棒棒");
	}
}

class InternetExplorer7 implements Subscriber {

	@Override
	public void 搶紅米機() {
		throw new RuntimeException("沒有動阿");
	}
}

class InternetExplorer6 implements Subscriber {

	@Override
	public void 搶紅米機() {
		throw new RuntimeException("已經到公海了");
	}
}

class InternetExplorer5 implements Subscriber {

	@Override
	public void 搶紅米機() {
		throw new RuntimeException("放大絕");
	}
}

class InternetExplorer4 implements Subscriber {

	@Override
	public void 搶紅米機() {
		throw new RuntimeException("壞了50收");
	}
}

class InternetExplorer3 implements Subscriber {

	@Override
	public void 搶紅米機() {
		throw new RuntimeException("超自然");
	}
}

class InternetExplorer2 implements Subscriber {

	@Override
	public void 搶紅米機() {
		throw new RuntimeException("不要問 很恐怖");
	}
}

class InternetExplorer1 implements Subscriber {

	@Override
	public void 搶紅米機() {
		throw new RuntimeException("靠邀，手機咧？");
	}
}

class Chrome implements Subscriber {

	@Override
	public void 搶紅米機() {
		System.out.println("你們都讓開，讓專業的來！！！");
	}
}