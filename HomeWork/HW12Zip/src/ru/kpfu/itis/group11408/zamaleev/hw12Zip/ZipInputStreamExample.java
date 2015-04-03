package ru.kpfu.itis.group11408.zamaleev.hw12Zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipInputStreamExample {
	
	public static void main(String[] args) {
		try(ZipInputStream zis = new ZipInputStream(new FileInputStream("ZipTest.zip"))){
			ZipEntry ze = null;
			while ((ze = zis.getNextEntry()) != null){
				System.out.println(ze.getName());
				try(FileOutputStream fos = new FileOutputStream(ze.getName())){
					int data = 0;
					while ((data = zis.read()) != -1){
						fos.write(data);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}			
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("TestOutZip.zip"))){
			if (args.length == 0){
				throw new IOException("Write folder to zip!!!");
			}
			byte[] buffer = new byte[1024];
			File dir = new File(args[0]);
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				FileInputStream fis = new FileInputStream(files[i]);
				zos.putNextEntry(new ZipEntry(files[i].getName()));
				int length;
				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
