package kr.co.direa.kjy.test.file.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import kr.co.direa.kjy.test.file.read.FileReadTest;

public class BufferedWriterTest {
	private static final String MYNAME = BufferedWriterTest.class.getSimpleName();
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		File file = new File("output/" + MYNAME);
		String str = FileReadTest.getFileContent();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long finish = System.currentTimeMillis();
		System.out.println("Running time: " + (finish - start)); // 110
	}

}
