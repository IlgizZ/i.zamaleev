package ru.kpfu.itis.group11408.zamaleev.hw13CJavaEditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class IOExample {

	public static void main(String[] args) {
		Charset winCharset = Charset.forName("windows-1251");
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("2.txt"), winCharset))) {
			for (int i = 1; i <= 100; i++) {
				writer.write("слово" + i + " ");
				if (i % 10 == 0) {
					writer.write("\n");
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream("2.txt"), winCharset))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
