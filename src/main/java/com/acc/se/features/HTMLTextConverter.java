package com.acc.se.features;

import java.io.*;

import org.jsoup.Jsoup;

public class HTMLTextConverter {
	static String path = System.getProperty("user.dir");

	// This method converts HTML Files into text documents.
	public static void convertHtmlToText() throws IOException, FileNotFoundException, NullPointerException {
		org.jsoup.nodes.Document my_document = null;
		BufferedWriter bw = null;

		try {
			File file = new File(path + "\\src\\main\\resources\\static\\data\\html");
			File[] file_Array = file.listFiles();
			int i = 0;
			for (File file1 : file_Array) {
				my_document = Jsoup.parse(file1, "UTF-8");
				String my_string = file1.getName().substring(0, file1.getName().lastIndexOf('.'));

				bw = new BufferedWriter(
						new FileWriter(path + "\\src\\main\\resources\\static\\data\\text\\ " + my_string + ".txt"));
				bw.write(my_document.text());
				bw.close();
			}

		} catch (Exception e) {
			System.out.println("file not found..!!!");
		}
	}

}
