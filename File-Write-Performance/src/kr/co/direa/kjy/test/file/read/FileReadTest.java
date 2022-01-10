package kr.co.direa.kjy.test.file.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class FileReadTest {
	private static final String LINE_SEP = System.getProperty("line.separator");
	private static String fileContent;

	static {
		File file = new File("resources/eula.1042.txt");
		readByBufferedReader(file);
	}

	public static void readByFileReader(File file) {
		try (FileReader reader = new FileReader(file);) {
			int ch;
			while ((ch = reader.read()) != -1) {
				System.out.print((char) ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readByBufferedReader(File file) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-16"))) {
			StringBuilder sb = new StringBuilder();
			String str;
			while ((str = reader.readLine()) != null) {
				sb.append(str + LINE_SEP);
			}
			fileContent = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getFileContent() {
		return fileContent;
	}

}
