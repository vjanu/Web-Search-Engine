package com.acc.se.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acc.se.features.SuggestKeywords;

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
		if (keywords.size() != 0) {
			model.addAttribute("suggestedkeywords", keywords);
			model.addAttribute("keyword", query);
		} else {
			model.addAttribute("alternatives", "");

		}
		return "search";
	}
}
