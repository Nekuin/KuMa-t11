package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
