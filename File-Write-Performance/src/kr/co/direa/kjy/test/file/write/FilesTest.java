package kr.co.direa.kjy.test.file.write;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import kr.co.direa.kjy.test.file.read.FileReadTest;

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
