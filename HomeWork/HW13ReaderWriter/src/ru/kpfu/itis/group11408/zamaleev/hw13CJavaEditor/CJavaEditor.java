package ru.kpfu.itis.group11408.zamaleev.hw13CJavaEditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CJavaEditor {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream("SecondTaskIn.txt")))) {
			String line = reader.readLine();
			String nextLine;
			String lineSeparator = System.getProperty("line.separator");
			try (BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(
							"SecondTaskOut.txt")))) {
				while (line != null) {
					nextLine = reader.readLine();
					if (nextLine == null) {
						writer.write(line);
						line = nextLine;
					} else if (line.indexOf("if") > 0
							&& nextLine.indexOf("{") > 0) {
						line = line.substring(0, line.indexOf(")") + 1);
						nextLine = nextLine.substring(nextLine.indexOf("{"),
								nextLine.length());
						writer.write(line + nextLine);
						line = reader.readLine();
					} else {
						writer.write(line);
						line = nextLine;
					}

					writer.write(lineSeparator);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
