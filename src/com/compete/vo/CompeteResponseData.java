package com.compete.vo;

import java.util.List;

public class CompeteResponseData {

	private Trends trends;
	private int query_cost;
	private String trends_frequency;
	private String trends_low_sample;
	private String keywords_frequency;
	private List<Keyword> keywords;
	private List<IncomingTraffic> incoming_referrals;

	public List<IncomingTraffic> getIncoming_referrals() {
		return incoming_referrals;
	}

	public void setIncoming_referrals(List<IncomingTraffic> incoming_referrals) {
		this.incoming_referrals = incoming_referrals;
	}

	public List<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}

	public String getKeywords_frequency() {
		return keywords_frequency;
	}

	public void setKeywords_frequency(String keywords_frequency) {
		this.keywords_frequency = keywords_frequency;
	}

	public int getQuery_cost() {
		return query_cost;
	}

	public void setQuery_cost(int query_cost) {
		this.query_cost = query_cost;
	}

	public String getTrends_frequency() {
		return trends_frequency;
	}

	public void setTrends_frequency(String trends_frequency) {
		this.trends_frequency = trends_frequency;
	}

	public String getTrends_low_sample() {
		return trends_low_sample;
	}

	public void setTrends_low_sample(String trends_low_sample) {
		this.trends_low_sample = trends_low_sample;
	}

	public Trends getTrends() {
		return trends;
	}

	public void setTrends(Trends trends) {
		this.trends = trends;
	}

}
