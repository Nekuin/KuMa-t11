package app;

import java.io.FileInputStream;
import java.io.IOException;

public class CommentRemover {
	
	private int state;
	private int WRITE = 1, COMMENT = 2, COMMENT_BLOCK = 3, NEW_LINE = 4, END_OF_BLOCK;
	private FileInputStream fis;
	
	public CommentRemover(FileInputStream fis) {
		this.fis = fis;
		this.state = 1;
		read();
	}
	
	private void read() {
		try {
			char c;
			while(this.fis.available() > 0) {
				c = (char) fis.read();
				
				
				if(c != '/' && state == WRITE) {
					//ei kommentti ja kirjoitetaan
					write(c);
					state = WRITE;
				} else if(c == '/' && state == WRITE) {
					//voiOllaAlku
					state = COMMENT;
				} else if(c == '/' && state == COMMENT) {
					state = NEW_LINE;
				} else if(c == '*' && state == COMMENT) {
					state = COMMENT_BLOCK;
				} else if(c != '/' && c != '*' && state == COMMENT) {
					write('/');
					write(c);
					state = WRITE;
				} else if(c == '\n' && state == NEW_LINE) {
					write(c);
					state = WRITE;
				} else if(c == '*' && state == COMMENT_BLOCK) {
					state = END_OF_BLOCK;
				} else if(c != '/' && state == END_OF_BLOCK) {
					state = COMMENT_BLOCK;
				} else if(c == '/' && state == END_OF_BLOCK) {
					state = WRITE;
				}
				
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * write a character to console
	 * @param ch char
	 */
	private void write(char ch) {
		System.out.print(ch);
	}
}
