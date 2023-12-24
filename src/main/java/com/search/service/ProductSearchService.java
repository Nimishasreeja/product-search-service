package com.search.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.search.entity.Product;
import com.search.entity.SearchRankDTO;
import com.search.repository.ProductSearchRepository;

@Component
public class ProductSearchService {

	private static final Logger logger = LoggerFactory.getLogger(ProductSearchService.class);

	@Autowired
	private ProductSearchRepository productRepository;

	public List<SearchRankDTO> getSearchRank(String[] keywords) {

		
			List<String> keywordList = new ArrayList<>();
			for (String searchKey : keywords) {

				String keyword = searchKey.trim();
				keywordList.add(keyword);
			}

			logger.info("Fetching the products from DB");
			List<Product> prodList = null;
			List<SearchRankDTO> rankList = new ArrayList<>();
			try {
				prodList = productRepository.findByKeywords(keywordList);
				if(prodList.isEmpty()) {
					logger.info("No record found");
					return rankList;
				}
			} catch (Exception e) {
				logger.error("An error occurred while processing search ranks", e.getMessage());
			}
			

			// Fetching the product by grouping keyword and take the position of the first
			// product from the brand as search rank when there are multiple products
			// from the same brand
			Map<String, List<Product>> groupedProducts = prodList.stream()
					.collect(Collectors.groupingBy(Product::getKeyword,
							Collectors.collectingAndThen(
									Collectors.toMap(Product::getBrand, p -> p,
											(p1, p2) -> p1.getPosition() <= p2.getPosition() ? p1 : p2),
									m -> new ArrayList<>(m.values()))));

			groupedProducts.forEach((keyword, products) -> {

				Map<String, Integer> positionMap = new HashMap<>();

				// if the brand's position is not within 40, then set the search rank as -1
				products.forEach(product -> {
					if (product.getPosition() > 40) {
						product.setPosition(-1);
					}

					positionMap.put(product.getBrand(), product.getPosition());

				});

				rankList.add(new SearchRankDTO(keyword, positionMap));

			});

			logger.info("Search ranks retrieved successfully");
			logger.info("Grouped Products: {}", groupedProducts);

			return rankList;

			}

	}


