package kr.co.direa.kjy.hello;

public class HelloWorld {
	public static void main(String[] args) {
		print();
		print("Jinyoung");
	}

	private static void print() {
		System.out.println("HELLO WORLD!!!");
	}
	
	private static void print(String name) {
		System.out.println("HELLO! " + name);
	}
}
