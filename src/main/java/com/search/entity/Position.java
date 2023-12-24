package com.search.entity;

public class Position {

	private String brand;

	private int rank;

	public Position(String brand, int rank) {
		super();
		this.brand = brand;
		this.rank = rank;
	}

	public Position() {

	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
