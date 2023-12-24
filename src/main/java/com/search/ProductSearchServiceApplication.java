package com.search;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.search.controller.ProductSearchController;
import com.search.entity.SearchRankDTO;

@SpringBootApplication
public class ProductSearchServiceApplication implements CommandLineRunner {

	@Autowired
	private ProductSearchController searchController;

	public static void main(String[] args) {
		SpringApplication.run(ProductSearchServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the keywords as comma separated");

		String keyword = scanner.nextLine();

		String[] keywords = keyword.split(",");

		List<SearchRankDTO> searchRank = searchController.getSearchRank(keywords);

		System.out.println(searchRank);
		scanner.close();

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(searchRank);
		System.out.println(json);

	}

}
