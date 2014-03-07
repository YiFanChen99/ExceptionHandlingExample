
public class Main {

	public static void main(String[] args) {
		SuperClass instance = new ConcreteTwo();
		instance.polymorphicMethod();
		instance = new ConcreteOne();
		instance.polymorphicMethod();
	}

}
