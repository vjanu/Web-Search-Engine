package com.acc.se.features;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Viraj
 *
 */
public class SuggestKeywords {
	private static ArrayList<String> keywordList = new ArrayList<>();
	static String path = System.getProperty("user.dir");

	private static void readTextFiles() throws IOException {
		File files = new File(path + "\\src\\main\\resources\\static\\data\\text");
		File[] texts = files.listFiles();
		StringBuilder line = new StringBuilder();
		for (File txt : texts) {
			BufferedReader br = new BufferedReader(new FileReader(txt));
			String str;
			while ((str = br.readLine()) != null) {
				line.append(str);
			}
			br.close();
		}
		String fullText = line.toString();
		StringTokenizer tokenizer = new StringTokenizer(fullText, ",`*$|~(){}_@><=+[]\\?;/&#-.!:\"'\n\t\r");
		while (tokenizer.hasMoreTokens()) {
			String tk = tokenizer.nextToken().toLowerCase(Locale.ROOT);
			if (!keywordList.contains(tk)) {
				keywordList.add(tk);
			}
		}
	}

	public static List<String> findKeyWords(String query) throws IOException {
		readTextFiles();
		HashMap<String, Integer> map = new HashMap<>();
		List<String> altWords = new ArrayList<String>();
		for (String w : keywordList) {
			int editDis = editDistance(query, w);
			map.put(w, editDis);
		}
		Map<String, Integer> map1 = sortByValue(map);
		int rank = 0;
		for (Map.Entry<String, Integer> en : map1.entrySet()) {
			if (en.getValue() != 0) {
				altWords.add(rank, en.getKey());
				rank++;
				if (rank == 10) {
					break;
				}
			}
		}
		return altWords;
	}

	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map) {
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue());
		HashMap<String, Integer> temp = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public static int editDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);

				if (c1 == c2) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;

					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
		return dp[len1][len2];
	}
}
