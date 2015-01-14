package tzhai.euler.lib;

import java.io.*;
import java.util.ArrayList;

public class FileLib {

	public static ArrayList<String> readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		ArrayList<String> arrayList = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			while ((tempString = reader.readLine()) != null) {
				arrayList.add(tempString);
				line++;
			}
			reader.close();
			return arrayList;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public static ArrayList<Integer> readFileByChars1(String fileName) {
		File file = new File(fileName);
		Reader reader = null;
		ArrayList<Integer> arrayList = new ArrayList<>();
		try {
			reader = new InputStreamReader(new FileInputStream(file));
			int tempChar;
			while ((tempChar = reader.read()) != -1) {
				// ����windows�£�\r\n�������ַ���һ��ʱ����ʾһ�����С�
				// ������������ַ��ֿ���ʾʱ���ỻ�����С�
				// ��ˣ����ε�\r������\n�����򣬽������ܶ���С�
				if (((char) tempChar) != '\r' && ((char) tempChar) != '\n') {
					arrayList.add(Character.getNumericValue(tempChar));
				}

			}
			reader.close();
			return arrayList;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public static String readFileByChar2(String fileName) {
		File file = new File(fileName);
		Reader reader = null;
		String string = "";
		try {
			reader = new InputStreamReader(new FileInputStream(file));
			int tempChar;
			while ((tempChar = reader.read()) != -1) {
				// ����windows�£�\r\n�������ַ���һ��ʱ����ʾһ�����С�
				// ������������ַ��ֿ���ʾʱ���ỻ�����С�
				// ��ˣ����ε�\r������\n�����򣬽������ܶ���С�
				if (((char) tempChar) != '\r' && ((char) tempChar) != '\n') {
					string += Character.toString((char) tempChar);
				}
			}
			reader.close();
			return string;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
}
