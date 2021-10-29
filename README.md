MyRepository
===============

> My First Repository

* 나의 작은 연습장

## HelloWorld
```java
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("HELLO WORLD!");
	}
}
```

## File Write Performance
```java
public class FilesTest {
	private static final String MYNAME = FilesTest.class.getSimpleName();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String str = FileReadTest.getFileContent();
		byte[] bytes = str.getBytes();
		Path path = Paths.get("output/" + MYNAME);
		try {
			Files.write(path, bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long finish = System.currentTimeMillis();
		System.out.println("Running time: " + (finish - start)); // 105
	}

}
```
