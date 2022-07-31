package com.acc.se.features;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class WordSearch {

	static String path = System.getProperty("user.dir");
	static HashMap<Integer, String> txtmap = new HashMap<Integer, String>();
	static HashMap<Integer, String> htmlmap = new HashMap<Integer, String>();

	public static HashMap<Integer, String> maptxt(String str, int i) {
		txtmap.put(i, str);
		return txtmap;
	}

	public static void gettxt() {
		System.out.println(txtmap);
	}

	public static String txtfilename(int i) // function to return file name
	{
		File folder = new File(path+"\\src\\main\\resources\\static\\data\\text");
		String[] path;
		path = folder.list();
		return path[i];
	}

	public static String htmlfilename(int i) // function to return file name
	{
		File folder = new File(path+"\\src\\main\\resources\\static\\data\\html");
		String[] path;
		path = folder.list();
		return path[i];
	}

	public static HashMap<Integer, String> wordSearch(String input) throws IOException // function to search for word in
																						// ALL text file
	{
		File folder_ = new File(path+"\\src\\main\\resources\\static\\data\\text");
		File[] file_list = folder_.listFiles();
		String[] words = null; // Intialize the word Array
		String str;

		int count = 0; // Intialize the word to zero

		for (int i = 0; i < file_list.length; i++) {
			if (file_list[i].isFile()) {
				FileReader file_reader = new FileReader(path+"\\src\\main\\resources\\static\\data\\text" + file_list[i].getName());
				BufferedReader buff = new BufferedReader(file_reader); // Creation of BufferedReader object

				while ((str = buff.readLine()) != null) // Reading Content from the file
				{
					words = str.split(" "); // Split the word using space
					for (String word : words) {
						if (word.equals(input)) // Search for the given word
						{
							count++; // If Present increase the count by one
						}
					}
				}
				if (count != 0) // Check for count not equal to zero
				{
					System.out.println("The given word is present for " + count + " Times in the file");
					System.out.println(txtfilename(i) + "\n");
					return maptxt(htmlfilename(i), count);
				}

				file_reader.close();
			}
		}
		return null;
	}

	public static void main(String[] args) throws IOException {

		Scanner ipobj = new Scanner(System.in);
		System.out.println("Enter the Word to Search");
		String input = ipobj.nextLine();
		wordSearch(input);
		gettxt();

	}

}
