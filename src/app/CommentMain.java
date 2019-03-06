package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CommentMain {

	public static void main(String[] args) {
		File file = new File("src/test.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			new CommentRemover(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
