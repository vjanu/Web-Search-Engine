package com.acc.se.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acc.se.dto.RankingPage;
import com.acc.se.features.SortSearching;
import com.acc.se.features.SuggestKeywords;
import com.acc.se.features.WordSearch;

/**
 * @author Viraj
 *
 */
@Controller
public class SearchController {

	@RequestMapping("/")
	public String loadHomePage() {
		return "index";
	}

	@RequestMapping("/search")
	public String getQuery(@RequestParam("searchkey") String query, Model model) throws IOException {
		List<String> keywords = SuggestKeywords.findKeyWords(query);
		HashMap<Integer, String> txtmap = new HashMap<Integer, String>();
		
		txtmap = WordSearch.wordSearch(query);

		if (!txtmap.isEmpty()) {
			List<RankingPage> files = new ArrayList<RankingPage>();

			files = SortSearching.sortKey(txtmap);
			model.addAttribute("results", files);
			model.addAttribute("hasOutput", true);
		} 
		else {
			model.addAttribute("hasOutput", false);
			if (keywords.size() != 0) {
				model.addAttribute("suggestedkeywords", keywords);
				model.addAttribute("keyword", query);
			} 
			else 
				model.addAttribute("alternatives", "");
		}
		return "search";
	}
}
