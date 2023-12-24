package com.search.entity;

import java.util.Map;

public class SearchRankDTO {
	private String keyword;

	public SearchRankDTO(String keyword, Map<String, Integer> positionMap) {
		super();
		this.keyword = keyword;
		this.position = positionMap;
	}

	private Map<String, Integer> position;

	public SearchRankDTO() {
	}

	public Map<String, Integer> getPosition() {
		return position;
	}

	public void setPosition(Map<String, Integer> position) {
		this.position = position;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
