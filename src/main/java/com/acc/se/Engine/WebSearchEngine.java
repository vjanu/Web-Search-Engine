package Engine;
import java.io.FileNotFoundException;
import java.io.IOException;

import Engine.WebCrawler;

public class WebSearchEngine {

	public WebSearchEngine() throws Exception {
		try {
			System.out.println("HTML TO TEXT");
			HTMLTextConverter.convertHtmlToText();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		System.out.println("############ WEB SEARCH ENGINE ############");
		
//		WebCrawler w = new WebCrawler();
//		w.get_page_links("https://www.ebay.com/sch/i.html?_nkw=cycle", 100);
		WebSearchEngine Engine = new WebSearchEngine();



	}}