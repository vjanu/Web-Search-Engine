package com.acc.se.dto;

/**
 * @author Viraj
 *
 */
public class RankingPage {

	private int rank;
	private String fileName;
	private int occurances;

	public int getOccurances() {
		return occurances;
	}

	public void setOccurances(int occurances) {
		this.occurances = occurances;
	}

	public RankingPage() {
	}

	public RankingPage(int rank, String fileName, int occurances) {
		this.rank = rank;
		this.fileName = fileName;
		this.occurances = occurances;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
