package kr.co.direa.kjy.test.file.write;

import java.io.File;
import java.io.FileOutputStream;

import kr.co.direa.kjy.test.file.read.FileReadTest;

public class FileOutputStreamTest {
	private static final String MYNAME = FileOutputStreamTest.class.getSimpleName();
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		File file = new File("output/" + MYNAME);
		String str = FileReadTest.getFileContent();
		byte[] bytes = str.getBytes();
		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long finish = System.currentTimeMillis();
		System.out.println("Running time: " + (finish - start)); // 96
	}

}
