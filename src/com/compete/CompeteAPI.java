package com.compete;

import com.compete.exception.CompeteAPIException;
import com.compete.invoker.CompeteAPIInvoker;
import com.compete.invoker.Config;
import com.compete.vo.CompeteResponse;

public class CompeteAPI {

	public CompeteResponse getGenderMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("gen", domain, null, null, null, config);
	}

	public CompeteResponse getGenderMetrics(String domain, String latest,
			Config config) throws CompeteAPIException {
		return invokeCompete("gen", domain, latest, null, null, config);
	}

	public CompeteResponse getGenderMetrics(String domain, String startDate,
			String endDate, Config config) throws CompeteAPIException {
		return invokeCompete("gen", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getRankMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("rank", domain, null, null, null, config);
	}

	public CompeteResponse getRankMetrics(String domain, String latest,
			Config config) throws CompeteAPIException {
		return invokeCompete("rank", domain, latest, null, null, config);
	}

	public CompeteResponse getRankMetrics(String domain, String startDate,
			String endDate, Config config) throws CompeteAPIException {
		return invokeCompete("rank", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getVisitsMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("vis", domain, null, null, null, config);
	}

	public CompeteResponse getVisitsMetrics(String domain, String latest,
			Config config) throws CompeteAPIException {
		return invokeCompete("vis", domain, latest, null, null, config);
	}

	public CompeteResponse getVisitsMetrics(String domain, String startDate,
			String endDate, Config config) throws CompeteAPIException {
		return invokeCompete("vis", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getUniqueVisitorsMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("uv", domain, null, null, null, config);
	}

	public CompeteResponse getUniqueVisitorsMetrics(String domain,
			String latest, Config config) throws CompeteAPIException {
		return invokeCompete("uv", domain, latest, null, null, config);
	}

	public CompeteResponse getUniqueVisitorsMetrics(String domain,
			String startDate, String endDate, Config config)
			throws CompeteAPIException {
		return invokeCompete("uv", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getPageVisitsMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("pv", domain, null, null, null, config);
	}

	public CompeteResponse getPageVisitsMetrics(String domain, String latest,
			Config config) throws CompeteAPIException {
		return invokeCompete("pv", domain, latest, null, null, config);
	}

	public CompeteResponse getPageVisitsMetrics(String domain,
			String startDate, String endDate, Config config)
			throws CompeteAPIException {
		return invokeCompete("pv", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getVisitsPerPersonMetrics(String domain,
			Config config) throws CompeteAPIException {
		return invokeCompete("vpp", domain, null, null, null, config);
	}

	public CompeteResponse getVisitsPerPersonMetrics(String domain,
			String latest, Config config) throws CompeteAPIException {
		return invokeCompete("vpp", domain, latest, null, null, config);
	}

	public CompeteResponse getVisitsPerPersonMetrics(String domain,
			String startDate, String endDate, Config config)
			throws CompeteAPIException {
		return invokeCompete("vpp", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getPagesPerVisitMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("ppv", domain, null, null, null, config);
	}

	public CompeteResponse getPagesPerVisitMetrics(String domain,
			String latest, Config config) throws CompeteAPIException {
		return invokeCompete("ppv", domain, latest, null, null, config);
	}

	public CompeteResponse getPagesPerVisitMetrics(String domain,
			String startDate, String endDate, Config config)
			throws CompeteAPIException {
		return invokeCompete("ppv", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getAverageStayMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("avgstay", domain, null, null, null, config);
	}

	public CompeteResponse getAverageStayMetrics(String domain, String latest,
			Config config) throws CompeteAPIException {
		return invokeCompete("avgstay", domain, latest, null, null, config);
	}

	public CompeteResponse getAverageStayMetrics(String domain,
			String startDate, String endDate, Config config)
			throws CompeteAPIException {
		return invokeCompete("avgstay", domain, null, startDate, endDate,
				config);
	}

	public CompeteResponse getAttentionMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("att", domain, null, null, null, config);
	}

	public CompeteResponse getAttentionMetrics(String domain, String latest,
			Config config) throws CompeteAPIException {
		return invokeCompete("att", domain, latest, null, null, config);
	}

	public CompeteResponse getAttentionMetrics(String domain, String startDate,
			String endDate, Config config) throws CompeteAPIException {
		return invokeCompete("att", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getReachDailyMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("reachd", domain, null, null, null, config);
	}

	public CompeteResponse getReachDailyMetrics(String domain, String latest,
			Config config) throws CompeteAPIException {
		return invokeCompete("reachd", domain, latest, null, null, config);
	}

	public CompeteResponse getReachDailyMetrics(String domain,
			String startDate, String endDate, Config config)
			throws CompeteAPIException {
		return invokeCompete("reachd", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getAttentionDailyMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("attd", domain, null, null, null, config);
	}

	public CompeteResponse getAttentionDailyMetrics(String domain,
			String latest, Config config) throws CompeteAPIException {
		return invokeCompete("attd", domain, latest, null, null, config);
	}

	public CompeteResponse getAttentionDailyMetrics(String domain,
			String startDate, String endDate, Config config)
			throws CompeteAPIException {
		return invokeCompete("attd", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getIncomeMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("inc", domain, null, null, null, config);
	}

	public CompeteResponse getIncomeMetrics(String domain, String latest,
			Config config) throws CompeteAPIException {
		return invokeCompete("inc", domain, latest, null, null, config);
	}

	public CompeteResponse getIncomeMetrics(String domain, String startDate,
			String endDate, Config config) throws CompeteAPIException {
		return invokeCompete("inc", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getAgeMetrics(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("age", domain, null, null, null, config);
	}

	public CompeteResponse getAgeMetrics(String domain, String latest,
			Config config) throws CompeteAPIException {
		return invokeCompete("age", domain, latest, null, null, config);
	}

	public CompeteResponse getAgeMetrics(String domain, String startDate,
			String endDate, Config config) throws CompeteAPIException {
		return invokeCompete("age", domain, null, startDate, endDate, config);
	}

	public CompeteResponse getKeywords(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("keyword", domain, null, null, null, config);
	}

	public CompeteResponse getKeywords(String domain, String latest,
			Config config) throws CompeteAPIException {
		return invokeCompete("keyword", domain, latest, null, null, config);
	}

	public CompeteResponse getKeywords(String domain, String startDate,
			String endDate, Config config) throws CompeteAPIException {
		return invokeCompete("keyword", domain, null, startDate, endDate,
				config);
	}

	public CompeteResponse getIncomingTraffic(String domain, Config config)
			throws CompeteAPIException {
		return invokeCompete("incoming_traffic", domain, null, null, null,
				config);
	}

	public CompeteResponse getIncomingTraffic(String domain, String latest,
			Config config) throws CompeteAPIException {
		return invokeCompete("incoming_traffic", domain, latest, null, null,
				config);
	}

	public CompeteResponse getIncomingTraffic(String domain, String startDate,
			String endDate, Config config) throws CompeteAPIException {
		return invokeCompete("incoming_traffic", domain, null, startDate,
				endDate, config);
	}

	private CompeteResponse invokeCompete(String metric, String domain,
			String latest, String startDate, String endDate, Config config)
			throws CompeteAPIException {
		CompeteAPIInvoker invoker = new CompeteAPIInvoker();
		invoker.setConfig(config);
		return invoker.getTrends(metric, domain, latest, startDate, endDate);

	}
}
