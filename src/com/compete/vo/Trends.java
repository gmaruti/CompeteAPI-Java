package com.compete.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trends {
	private List<Datum> male;
	private List<Datum> female;
	private List<Datum> rank;
	private List<Datum> vis;
	private List<Datum> uv;
	private List<Datum> pv;
	private List<Datum> vpp;
	private List<Datum> ppv;
	private List<Datum> avgstay;
	private List<Datum> att;
	private List<Datum> reachd;
	private List<Datum> attd;
	private Map<String, List<Datum>> income = new HashMap<String, List<Datum>>();
	private Map<String, List<Datum>> age = new HashMap<String, List<Datum>>();

	
	public List<Datum> getReachd() {
		return reachd;
	}

	public void setReachd(List<Datum> reachd) {
		this.reachd = reachd;
	}

	public List<Datum> getAttd() {
		return attd;
	}

	public void setAttd(List<Datum> attd) {
		this.attd = attd;
	}

	public Map<String, List<Datum>> getIncome() {
		return income;
	}

	public void setIncome(Map<String, List<Datum>> income) {
		this.income = income;
	}

	public Map<String, List<Datum>> getAge() {
		return age;
	}

	public void setAge(Map<String, List<Datum>> age) {
		this.age = age;
	}

	public List<Datum> getRank() {
		return rank;
	}

	public void setRank(List<Datum> rank) {
		this.rank = rank;
	}

	public List<Datum> getVis() {
		return vis;
	}

	public void setVis(List<Datum> vis) {
		this.vis = vis;
	}

	public List<Datum> getUv() {
		return uv;
	}

	public void setUv(List<Datum> uv) {
		this.uv = uv;
	}

	public List<Datum> getPv() {
		return pv;
	}

	public void setPv(List<Datum> pv) {
		this.pv = pv;
	}

	public List<Datum> getVpp() {
		return vpp;
	}

	public void setVpp(List<Datum> vpp) {
		this.vpp = vpp;
	}

	public List<Datum> getPpv() {
		return ppv;
	}

	public void setPpv(List<Datum> ppv) {
		this.ppv = ppv;
	}

	public List<Datum> getAvgstay() {
		return avgstay;
	}

	public void setAvgstay(List<Datum> avgstay) {
		this.avgstay = avgstay;
	}

	public List<Datum> getAtt() {
		return att;
	}

	public void setAtt(List<Datum> att) {
		this.att = att;
	}

	public List<Datum> getMale() {
		return male;
	}

	public void setMale(List<Datum> male) {
		this.male = male;
	}

	public List<Datum> getFemale() {
		return female;
	}

	public void setFemale(List<Datum> female) {
		this.female = female;
	}

}
