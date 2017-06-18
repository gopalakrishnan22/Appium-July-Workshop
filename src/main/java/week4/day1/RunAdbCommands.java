package week4.day1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunAdbCommands {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		Process p = Runtime.getRuntime().exec("adb shell dumpsys battery | findStr level");
		System.out.println(p.getInputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String line = "";
		while ((line = reader.readLine())!= null) {
			System.out.println(line);
		}


	}

}
