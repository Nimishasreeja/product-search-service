package com.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.search.entity.SearchRankDTO;
import com.search.service.ProductSearchService;

@RestController
@RequestMapping("/api")
public class ProductSearchController {
	

	@Autowired
	private ProductSearchService productService;

	/**
	 * Retrieves search ranks for each brand for the given keyword.
	 *
	 * @param keywords: Array of strings containing the search keywords.
	 * @return A list of SearchRankDTO objects containing search ranks for each
	 *         brand for the given keyword.
	 * 
	 */

	@GetMapping("/searchRank")
	public List<SearchRankDTO> getSearchRank(String[] keywords) {
		
			// Validate input keywords
			if (keywords == null || keywords.length == 0) {
				throw new IllegalArgumentException("Keywords cannot be empty");
			}

			return productService.getSearchRank(keywords);
		

	}

}
