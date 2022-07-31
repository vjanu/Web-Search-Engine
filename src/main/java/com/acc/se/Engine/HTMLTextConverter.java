package Engine;
import java.io.*;

import org.jsoup.Jsoup;

public class HTMLTextConverter {

	// This method converts HTML Files into text documents.
	public static void convertHtmlToText() throws IOException, FileNotFoundException, NullPointerException {
		org.jsoup.nodes.Document my_document = null;
		BufferedWriter bw = null;

		try {
			File file = new File("D:\\Web-Search-Engine-main\\HTML files\\");
			File[] file_Array = file.listFiles();
			int i = 0;
			for (File file1 : file_Array) 
			{
				my_document = Jsoup.parse(file1, "UTF-8");
				String my_string = file1.getName().substring(0, file1.getName().lastIndexOf('.'));
				//convert files
				bw = new BufferedWriter(new FileWriter("D:\\Web-Search-Engine-main\\text\\" + my_string + ".txt"));
				bw.write(my_document.text());
				bw.close();
				// System.out.println("File " + file.getName() + " converted into " +
				// file.getName()+ ".txt successfully");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
