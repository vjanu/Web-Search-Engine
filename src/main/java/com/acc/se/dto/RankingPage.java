package com.acc.se.dto;

/**
 * @author Viraj
 *
 */
public class RankingPage {
	
	private int rank;
	private String fileName;
	
	public RankingPage() {}
	
	public RankingPage(int rank, String fileName) {
		this.rank = rank;
		this.fileName = fileName;	
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
