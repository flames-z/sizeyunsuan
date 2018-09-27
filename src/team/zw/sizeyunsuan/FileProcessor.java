package team.zw.sizeyunsuan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

import jdk.management.resource.internal.inst.FileChannelImplRMHooks;

public class FileProcessor {
	public FileProcessor() {
		
	}
	
	public static void readFile(String filePath) {
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "utf-8");
			BufferedReader bReader = new BufferedReader(isr);
			String string = null;
			while((string = bReader.readLine()) != null) {
				string = string.trim();
			}
			isr.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void exportFile() throws IOException {
		File dir = new File("");
		String path = dir.getAbsolutePath();
		
		String fileName = path + "Exercise.txt";
		File file = new File(fileName);
		try {
			if(file.exists()) {
				file.delete();
			}
			file.createNewFile();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.print(path);
		
	}
	
	public static boolean writeFileContent(String newstr, String filepath) {
		String filein = newstr + "\n";
        boolean flag=false;
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(filepath);
            fileOutputStream.write(newstr.getBytes("gbk"));
            fileOutputStream.close();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
	}
	
	public static void main(String[] args) throws IOException{
		FileProcessor.exportFile();
		
	}
}
