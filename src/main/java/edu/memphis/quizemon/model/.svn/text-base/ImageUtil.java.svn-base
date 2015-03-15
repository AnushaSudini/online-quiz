package edu.memphis.quizemon.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {
	private static File file = null;
	
	public static FileInputStream getImageByte(String infile) {
		FileInputStream imageByte = null;
		file = new File(infile);
		try {
			imageByte = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return imageByte;
	}
	
	public static void readBlob(InputStream inputStream, String path) throws IOException {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, len);
			}
			inputStream.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
